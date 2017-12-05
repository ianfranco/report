SELECT 
    trabajador.id_trabajador,
    trabajador.codigo_trabajador AS Codigo,
    CONCAT(trabajador.apellido_paterno_trabajador,
            ' ',
            trabajador.apellido_materno_trabajador,
            ' ',
            trabajador.nombre_trabajador) AS Conductor,
    trabajador.rut_trabajador AS Rut,
    
    empresa.id_empresa,
    @ahorro_voluntario:=trabajador.monto_apv AS AhorroVoluntario,
    empresa.nombre_empresa AS NombreEmpresario,
    empresa.rut_empresa AS RutEmpresario,
    terminal.id_terminal AS CON_GAR, 
    terminal.nombre_terminal, 
    
    relacion_laboral.id_relacion_laboral,
    @tipoContrato:=relacion_laboral.id_tipo_contrato AS id_tipo_contrato,
    relacion_laboral.fecha_inicio AS FechaContrato,
    relacion_laboral.fecha_fin,
    relacion_laboral.estado,
    
    
    @feriadoDesde:=(SELECT feriado_legal.fecha_desde_feriado FROM feriado_legal WHERE id_trabajador = relacion_laboral.id_trabajador AND datediff(feriado_legal.fecha_desde_feriado, relacion_laboral.fecha_inicio)>300) as desdeFeriado, 
    @feriadoHasta:=(SELECT feriado_legal.fecha_hasta_feriado FROM feriado_legal WHERE id_trabajador = relacion_laboral.id_trabajador AND datediff(feriado_legal.fecha_desde_feriado, relacion_laboral.fecha_inicio)>300) as hastaFeriado, 
	@montoFeriado:=IFNULL((SELECT feriado_legal.valor_feriado FROM feriado_legal WHERE id_trabajador = relacion_laboral.id_trabajador AND datediff(feriado_legal.fecha_desde_feriado, relacion_laboral.fecha_inicio)>300),0) as montoFeriado, 
    
    @abono_uno:=IF(@tipoContrato<>6, (SELECT IFNULL(SUM(monto), 0) FROM haber_trabajador_liquidacion WHERE haber_trabajador_liquidacion.id_trabajador = trabajador.id_trabajador AND haber_trabajador_liquidacion.id_haber_trabajador = 1), 0) AS abono_uno, 
    
      trabajador.numero_cargas AS 'N° Cargas', 
    trabajador.id_asignacion_familiar AS 'GRUPO', 
    
    @fecha_desde_contrato:= IF(fecha_inicio < '2016-09-01',
                '2016-09-01',
                fecha_inicio) AS fecha_desde_contrato, 
	@fecha_hasta_contrato:=IF(fecha_fin BETWEEN '2016-09-01' AND '2016-09-30' AND fecha_fin<>fecha_inicio,
                fecha_fin,
                '2016-09-30') AS fecha_hasta_contrato, 
                
	
                
    @cinco_porciento:=sum_cinco_porciento(trabajador.id_trabajador, @fecha_desde_contrato) AS cinco_porciento, 
    
    @cinco_porciento_filtrado:=total_cinco_por_ciento(
    trabajador.id_trabajador,@feriadoDesde,  @feriadoHasta, @fecha_desde_contrato, @fecha_hasta_contrato
    
    ) AS cinco_porciento_filtrado, 
    
    @ahorro_guia:=sum_ahorro_guia(
    trabajador.id_trabajador,@feriadoDesde,  @feriadoHasta, @fecha_desde_contrato, @fecha_hasta_contrato) AS ahorro_guia, 
    @bruto:=MONTO_BRUTO(relacion_laboral.id_trabajador,
            @feriadoDesde,
            @feriadoHasta,
            IF(fecha_inicio < '2016-09-01',
                '2016-09-01',
                fecha_inicio),
            IF(fecha_inicio = fecha_fin,
                '2016-09-30',
                fecha_fin)) AS BRUTO,
	@dl:=IFNULL((SELECT 
                    SUM(DATEDIFF(licencia_medica.fecha_hasta_reposo,
                                licencia_medica.fecha_desde_reposo) + 1) AS dias
                FROM
                    licencia_medica
                WHERE
                    licencia_medica.id_trabajador = relacion_laboral.id_trabajador),
            0) AS DL,
    @total:=TOTAL_DIAS_TRABAJADOS(relacion_laboral.id_tipo_contrato, @dl,  relacion_laboral.id_trabajador,
            @feriadoDesde,
            @feriadoHasta,
            IF(fecha_inicio < '2016-09-01',
                '2016-09-01',
                fecha_inicio),
            IF(fecha_inicio = fecha_fin,
                '2016-09-30',
                fecha_fin)) AS total_dias_trabajados,
    
    @total_dias_limpios:=TOTAL_DIAS_LIMPIOS(relacion_laboral.id_tipo_contrato, @dl,  relacion_laboral.id_trabajador,
            @feriadoDesde,
            @feriadoHasta,
            IF(fecha_inicio < '2016-09-01',
                '2016-09-01',
                fecha_inicio),
            IF(fecha_inicio = fecha_fin,
                '2016-09-30',
                fecha_fin)) AS total_dias_limpios,
    
    @dt:=IFNULL((SELECT 
                    COUNT(guia.folio)
                FROM
                    guia
                WHERE
                    guia.fecha_guia BETWEEN '2016-09-01' AND IF(fecha_inicio = fecha_fin,
                        '2016-09-30',
                        fecha_fin)
                        AND guia.id_trabajador = relacion_laboral.id_trabajador),
            0) AS DT,
    
    @dv:=IFNULL(DATEDIFF(@feriadoHasta,@feriadoDesde), 0) AS DV,
    @total_dias:=ROUND(@total + @dl ) AS total_dias,
    @dd:=ROUND(IF(fecha_fin BETWEEN '2016-09-01' AND '2016-09-30'
                    AND fecha_inicio <> fecha_fin,
                DAY(fecha_fin) - @total_dias,
                30 - @total_dias)) AS DD,
                
	@final_dias:=ROUND(IF(@total=0 AND @dl>0, @dd, IF(@total=0 AND @dl=0,  IF(fecha_fin BETWEEN '2016-09-01' AND '2016-09-30'
                    AND fecha_inicio <> fecha_fin,
                DAY(fecha_fin) - @total_dias,30), @total))) AS final_dias, 
                
                
                
    @imponible:=IF(ROUND(@bruto * 0.19) = 0
            AND relacion_laboral.id_tipo_contrato = 5,
        relacion_laboral.sueldo_base,
        ROUND(@bruto * 0.19)) AS imponible2,
    @imponibleReal:=CALCULA_IMPONIBLE(@bruto,
            relacion_laboral.sueldo_base,
            IFNULL(@montoFeriado, 0),
            @total,
            @dl,
            @dv,
            @dd,
            relacion_laboral.id_tipo_contrato,
            IF(fecha_inicio = fecha_fin,
                '2016-09-30',
                fecha_fin), fecha_inicio, 
            relacion_laboral.estado) AS Imponible,
            
            @bruto2:=IF(@tipoContrato=5, 0, @bruto) AS bruto2, 
            
            
@sueldobase:=ROUND(IF(@tipoContrato=5, relacion_laboral.sueldo_base, IF(@total_dias_limpios>10 AND @dv=10, ROUND((257500/30)*@total_dias_limpios) , IF(@total_dias_limpios =0 AND @imponibleReal>0 , @imponibleReal ,ROUND(IF(@total_dias_limpios>10, 257500, (257500/30)*@total_dias_limpios))) ))) AS SueldoBase,                         
            @cuatroPorciento:=ROUND(@bruto2*0.04) AS cuatro_porciento, 
            @uno_comados:=ROUND(@bruto2*0.012) AS uno_comados,
            @uno_porciento:=ROUND(@bruto2*0.012) AS uno_porciento,
            @cero_comaocho:=ROUND(@bruto2*0.008) AS cero_comaocho, 
            @dos_porciento:=ROUND(@bruto2*0.02) AS dos_porciento, 
            @porcentajes:=ROUND(@uno_comados + @cero_comaocho + @dos_porciento ) AS final_porcentajes, 
            @ajuste:=ROUND(@imponibleReal-(@sueldobase+@porcentajes+@montoFeriado)) AS base, 
            
            @ajuste_comision:=ROUND(IF(@ajuste<0, @ajuste+1, IF(@ajuste=1, 0, @ajuste))) AS AJUSTE_COMISION, 
            @dos_porciento:=ROUND(IF(@ajuste<0, @dos_porciento-1, IF(@ajuste=1,@dos_porciento+1 ,@dos_porciento ))) AS final_dos_porciento, 
            
    institucion_prevision.nombre_institucion_prevision AS AFP_NOM,
    IF(trabajador.id_institucion_prevision<99, CONCAT("(",ROUND(institucion_prevision.porcentaje_descuento,2), "%)"), "(0.0%)") AS porcentaje_descuento,
    IF(institucion_salud.id_institucion_salud <> 7,
        institucion_salud.nombre_institucion_salud,
        '') AS NombreIsapre,
   monto_salud AS ISAPRE,
    @valorafp:=IF(trabajador.id_institucion_prevision<99, ROUND((institucion_prevision.porcentaje_descuento / 100) * @imponibleReal), 0) AS ValorAfp,
    trabajador.id_tipo_cotizacion_trabajador,
    @cesantia:=CALCULA_CESANTIA(@imponibleReal,
            @dl,
            @total_dias_limpios,
            relacion_laboral.fecha_inicio,
            trabajador.id_tipo_cotizacion_trabajador,
            trabajador.subsidio_joven) AS Cesantia,
    @cesantiaEmpresario:=CALCULA_CESANTIA_EMPLEADOR(@imponibleReal,
            @dl,
            relacion_laboral.fecha_inicio,
            trabajador.id_tipo_cotizacion_trabajador,
            trabajador.subsidio_joven) AS CesantiaEmpresario,
    @tresporciento:=CALCULA_TRESPORCIENTO_EMPLEADOR(@imponibleReal,
            @cesantia,
            @dl,
            relacion_laboral.fecha_inicio,
            trabajador.id_tipo_cotizacion_trabajador,
            trabajador.subsidio_joven) AS tresporciento,
    @sis:=IF(institucion_prevision.id_institucion_prevision < 99,
        ROUND(@imponibleReal * 0.0141),
        0) AS SIS,
    @valorinp:=CALCULA_INP(@imponibleReal,
            trabajador.id_institucion_prevision,
            trabajador.id_institucion_salud,
            empresa.id_caja_compensacion,
            empresa.id_mutual) AS INP,
    @porcentajeinp:=calcula_porcentaje_inp(@imponibleReal,
            trabajador.id_institucion_prevision,
            trabajador.id_institucion_salud,
            empresa.id_caja_compensacion,
            empresa.id_mutual) AS 'porcentajeINP',
    @valorcaja:=IF(institucion_salud.id_institucion_salud <> 7,
        0,
        IF(empresa.id_caja_compensacion = 6,
            ROUND(@imponibleReal * 0.006),
            0)) AS 'Caja18',
    @porcentajeCaja:=IF(institucion_salud.id_institucion_salud <> 7,
        0,
        IF(empresa.id_caja_compensacion = 6,
            '0.6%',
            '0.0%')) AS 'porcentajeCaja',
    @total:=@cesantia + @cesantiaEmpresario + @tresporciento + @sis + @valorafp AS TotalROW,
    @total_descuentos:= ROUND(@valorafp+@cesantia+@valorinp+@valorcaja+monto_salud) AS total_descuentos, 
    
    @sindicato:=IF(@total_dias_limpios <> 0, IF(@tipoContrato<>6 , IFNULL((SELECT cuota_sindicato FROM sindicato_trabajador  LEFT JOIN sindicato ON sindicato_trabajador.id_sindicato = sindicato.id_sindicato WHERE sindicato_trabajador.id_trabajador = trabajador.id_trabajador),0), 0), 0)  AS sindicato,
    
    @cargo_saldo:=IF(@tipoContrato<>6, (SELECT IFNULL(SUM(monto), 0) FROM descuento_trabajador_liquidacion WHERE descuento_trabajador_liquidacion.id_trabajador = trabajador.id_trabajador AND descuento_trabajador_liquidacion.id_descuento_trabajador = 4), 0) AS SaldoAnterior, 
    @cargo_retencion:=IF(@tipoContrato<>6, (SELECT IFNULL(SUM(monto), 0) FROM descuento_trabajador_liquidacion WHERE descuento_trabajador_liquidacion.id_trabajador = trabajador.id_trabajador AND descuento_trabajador_liquidacion.id_descuento_trabajador = 1), 0)  AS RetencionJudicial, 
    @cargo_credito:=IF(@tipoContrato<>6, (SELECT IFNULL(SUM(monto), 0) FROM descuento_trabajador_liquidacion WHERE descuento_trabajador_liquidacion.id_trabajador = trabajador.id_trabajador AND descuento_trabajador_liquidacion.id_descuento_trabajador = 2), 0)  AS CreditoCaja, 
    @cargo_rec:=IF(@tipoContrato<>6, (SELECT IFNULL(SUM(monto), 0) FROM descuento_trabajador_liquidacion WHERE descuento_trabajador_liquidacion.id_trabajador = trabajador.id_trabajador AND descuento_trabajador_liquidacion.id_descuento_trabajador = 5), 0)  AS ReconocimientoDeuda, 
    
    @cargo_segunda_imp:=IF(@tipoContrato=6, (SELECT IFNULL(SUM(monto), 0) FROM descuento_trabajador_liquidacion WHERE descuento_trabajador_liquidacion.id_trabajador = trabajador.id_trabajador AND descuento_trabajador_liquidacion.id_descuento_trabajador = 7), 0)  AS Descuentox2imp, 
    
    @total_cargos:=ROUND(@cargo_rec+@cargo_saldo+@cargo_retencion+@cargo_credito+@total_descuentos+@ahorro_voluntario+@sindicato+@cargo_segunda_imp) AS descuentos_trabajador, 
    
    
    @saldo_final_descuentos:=ROUND( (@cinco_porciento_filtrado+@ahorro_guia)-@total_cargos) AS saldo_final_descuentos, 
    @saldo_real:=ROUND(IF(@saldo_final_descuentos>0, @saldo_final_descuentos, 0)) AS saldo_real, 
    

    
CONCAT(IF(relacion_laboral.fecha_fin BETWEEN '2016-09-01' AND '2016-09-30'
                    AND relacion_laboral.fecha_inicio <> relacion_laboral.fecha_fin,
                CONCAT('C:',
                        DAY(relacion_laboral.fecha_fin),
                        '-',
                        MONTH(relacion_laboral.fecha_fin)),
                ''),
            IF(@feriadoDesde IS NULL,
                '',
                CONCAT(' V:',
                        DAY(@feriadoDesde),
                        '-',
                        MONTH(@feriadoDesde),
                        '/',
                        DAY(@feriadoHasta),
                        '-',
                        MONTH(@feriadoHasta))),
            IF(licencia_medica.fecha_desde_reposo IS NULL,
                '',
                CONCAT(' L:',
                        DAY(licencia_medica.fecha_desde_reposo),
                        '-',
                        MONTH(licencia_medica.fecha_desde_reposo),
                        '/',
                        DAY(licencia_medica.fecha_hasta_reposo),
                        '-',
                        MONTH(licencia_medica.fecha_hasta_reposo)))) AS observacion
FROM
    trabajador
        RIGHT JOIN
    relacion_laboral ON relacion_laboral.id_trabajador = trabajador.id_trabajador
        LEFT JOIN
    empresa ON relacion_laboral.id_empresa = empresa.id_empresa
        LEFT JOIN
    licencia_medica ON trabajador.id_trabajador = licencia_medica.id_trabajador        
        LEFT JOIN
    institucion_prevision ON trabajador.id_institucion_prevision = institucion_prevision.id_institucion_prevision
        LEFT JOIN
    institucion_salud ON trabajador.id_institucion_salud = institucion_salud.id_institucion_salud
		LEFT JOIN 	
    trabajador_terminal ON trabajador.id_trabajador = trabajador_terminal.id_trabajador 		
        LEFT JOIN         
	terminal ON trabajador_terminal.id_terminal = terminal.id_terminal 
WHERE
    fecha_fin BETWEEN IF(fecha_inicio = fecha_fin,
        fecha_inicio,
        '2016-09-01') AND '2016-09-30' AND relacion_laboral.tipo_contrato = '0' 
        
        ORDER BY terminal.nombre_terminal, empresa.nombre_empresa, trabajador.apellido_paterno_trabajador