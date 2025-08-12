CREATE OR REPLACE FUNCTION public.historico_agendamentos_paciente(p_paciente_id INTEGER)
    RETURNS TABLE (
                      id_agendamento INT,
                      nome_psicologo TEXT,
                      data_agendamento TIMESTAMP,
                      status_agendamento VARCHAR(20)
                  ) AS $$
BEGIN
    RETURN QUERY
        SELECT
            CAST(a.id AS INTEGER),
            p.nome,
            a.data,
            a.status
        FROM
            public.Atendimento a
                JOIN
            public.psicologo p ON a.psicologo_id = p.id
        WHERE
            a.paciente_id = p_paciente_id
        ORDER BY
            a.data DESC;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM public.historico_agendamentos_paciente(2);

CREATE OR REPLACE FUNCTION public.relatorio_desempenho_mensal(p_mes INTEGER, p_ano INTEGER)
    RETURNS TABLE (
        psicologo_id INTEGER,
        nome_psicologo  TEXT,
        total_atendimentos_realizados BIGINT
    ) AS $$
BEGIN
    RETURN QUERY
        SELECT
            p.id,
            p.nome,
            COUNT(a.id)
        FROM
            public.psicologo AS p
                LEFT JOIN
            public.Atendimento AS a ON p.id = a.psicologo_id
                AND a.status = 'REALIZADO'
                AND EXTRACT(MONTH FROM a.data) = p_mes
                AND EXTRACT(YEAR FROM a.data) = p_ano
        GROUP BY
            p.id, p.nome
        ORDER BY
            p_mes, p_ano DESC;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM public.relatorio_desempenho_mensal(5, 2024);