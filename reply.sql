//1
SELECT ENAME as nome_funcionario,
HIREDATE as data_contratacao
FROM EMP
WHERE HIREDATE >= SYSDATE - 30;

//2
SELECT ENAME AS nome_funcionario,
NVL(COMM,0) as comissao
FROM EMP;

//3
SELECT DEPT.DNAME AS nome_departamento,
COUNT (EMP.ENAME)
FROM DEPT
INNER JOIN EMP
ON EMP.DEPTNO = DEPT.DEPTNO
GROUP BY (DEPT.DNAME)
ORDER BY COUNT (EMP.ENAME) DESC;

//4
SELECT 
    JOB,
    EMPNO,
    ENAME,
    SAL
FROM EMP E
WHERE SAL = (
    SELECT MIN(SAL)
    FROM EMP
    WHERE JOB = E.JOB
);

//5
SELECT 
    DEPTNO, 
    COUNT(*) AS QTD_FUNCIONARIOS
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) > 3;

//6
SELECT 
    E.EMPNO, 
    E.ENAME, 
    E.JOB, 
    D.LOC AS CIDADE_ALOCACAO
FROM 
    EMP E
JOIN 
    DEPT D ON E.DEPTNO = D.DEPTNO;

//7
CREATE OR REPLACE FUNCTION get_salario_funcionario (p_empno IN NUMBER) 
RETURN NUMBER 
IS
    v_salario NUMBER;
BEGIN
    -- Tentar buscar o salário do funcionário
    SELECT SAL
    INTO v_salario
    FROM EMP
    WHERE EMPNO = p_empno;
    
    -- Retornar o salário encontrado
    RETURN v_salario;
    
EXCEPTION
    -- Caso o funcionário não seja encontrado, retorna -1
    WHEN NO_DATA_FOUND THEN
        RETURN -1;
END;
/

//8
CREATE OR REPLACE FUNCTION get_funcionario_maior_salario (p_job IN VARCHAR2) 
RETURN NUMBER 
IS
    v_empno NUMBER;
BEGIN
    -- Tenta buscar o EMPNO do funcionário com maior salário e, em caso de empate, o mais recente
    SELECT EMPNO
    INTO v_empno
    FROM EMP
    WHERE JOB = p_job
    AND SAL = (SELECT MAX(SAL) FROM EMP WHERE JOB = p_job)
    ORDER BY HIREDATE DESC
    FETCH FIRST 1 ROWS ONLY;
    
    -- Retorna o EMPNO do funcionário encontrado
    RETURN v_empno;
    
EXCEPTION
    -- Caso não encontre nenhum funcionário para o cargo, retorna NULL
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END;
/

//9
CREATE OR REPLACE PROCEDURE funcionarios_por_cidade(p_cidade IN VARCHAR2) 
IS
    CURSOR c_funcionarios IS
        SELECT E.EMPNO, E.JOB, E.SAL
        FROM EMP E
        JOIN DEPT D ON E.DEPTNO = D.DEPTNO
        WHERE D.LOC = p_cidade;
    
    v_empno EMP.EMPNO%TYPE;
    v_job EMP.JOB%TYPE;
    v_sal EMP.SAL%TYPE;
BEGIN
    OPEN c_funcionarios;
    FETCH c_funcionarios INTO v_empno, v_job, v_sal;
    
    IF c_funcionarios%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('nenhum funcionário encontrado');
    ELSE
        LOOP
            DBMS_OUTPUT.PUT_LINE('ID: ' || v_empno || ', Cargo: ' || v_job || ', Salário: ' || v_sal);
            FETCH c_funcionarios INTO v_empno, v_job, v_sal;
        END LOOP;
    END IF;
    
    CLOSE c_funcionarios;
END;
/

//10
ALTER TABLE EMP 
ADD (ULTIMO_AUMENTO NUMBER(7,2));

CREATE OR REPLACE TRIGGER trg_atualiza_aumento
BEFORE UPDATE OF SAL ON EMP
FOR EACH ROW
BEGIN
    -- Calcula o aumento e armazena na coluna ULTIMO_AUMENTO
    :NEW.ULTIMO_AUMENTO := :NEW.SAL - :OLD.SAL;
END;
/

//11

Durante minha atuação como analista de suporte na Keller Williams, enfrentei um desafio que envolveu um conflito entre usuários finais e a equipe de desenvolvimento. Os associados reportavam dificuldades com um módulo específico do sistema, que estava impactando diretamente suas operações no dia a dia. Por outro lado, a equipe técnica defendia que o problema era causado por um uso inadequado da ferramenta, o que gerou insatisfação e frustração entre os colaboradores.

Para lidar com a situação, adotei uma abordagem colaborativa e proativa. Comecei ouvindo ambas as partes para compreender os pontos de vista e documentei os problemas relatados pelos usuários, incluindo detalhes como horários, funcionalidades afetadas e o impacto nas operações. Posteriormente, organizei uma reunião com a equipe de desenvolvimento, apresentando os dados coletados e destacando a necessidade de uma solução conjunta.

Propus a realização de sessões de treinamento para os usuários, enquanto a equipe técnica investigava possíveis falhas no sistema. Durante essas sessões, fiquei responsável por esclarecer dúvidas e criar materiais educativos para melhorar o uso da ferramenta. Paralelamente, mantive uma comunicação constante entre os usuários e o time técnico, atualizando ambos sobre o progresso.

Ao final, conseguimos solucionar o problema, que envolvia ajustes no sistema e uma reformulação no treinamento dos associados. Essa experiência não só resolveu o conflito como também aumentou a confiança dos colaboradores na equipe de suporte e desenvolvimento, fortalecendo o trabalho em equipe.

Esse episódio destacou a importância da comunicação clara, da empatia e da análise de dados para mediar conflitos e buscar soluções efetivas. Além disso, reforçou minha habilidade de manter a calma em situações desafiadoras, sempre com foco no resultado final e na melhoria contínua.

//12

During my time at Keller Williams, I encountered a situation where we faced significant time pressure to update critical data for the Market Centers. The deadline was tight, and the team had to quickly upload property information while ensuring system integrity. However, given the urgency, it was clear that a full quality review of the data would be impossible without delaying the process.

To address this, I prioritized accuracy in the most critical fields, ensuring that essential information like property identifiers and pricing was correct. I proposed to the team that non-critical details could be revised in a second phase. This allowed us to meet the deadline while minimizing potential risks. After the initial upload, I organized follow-ups to verify and correct any issues in the remaining data.

This experience taught me how to balance quality and efficiency under pressure, focusing on what is essential while planning for improvements when time and resources allow. It also emphasized the importance of clear communication and teamwork in mitigating the impact of constraints.

CREATE TABLE EMP
(
EMPNO NUMBER(4),
ENAME VARCHAR2(10 BYTE),
JOB VARCHAR2(9 BYTE),
MGR NUMBER(4),
HIREDATE DATE,
SAL NUMBER(7,2),
COMM NUMBER(7,2),
DEPTNO NUMBER(2)
)

CREATE UNIQUE INDEX PK_EMP ON EMP
(EMPNO)

CREATE TABLE DEPT
(
DEPTNO NUMBER(2),
DNAME VARCHAR2(14 BYTE),
LOC VARCHAR2(13 BYTE)
)
CREATE UNIQUE INDEX PK_DEPT ON DEPT
(DEPTNO)


INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (40, 'OPERATIONS', 'BOSTON');

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('17-12-1980', 'DD-MM-YYYY'), 800, NULL, 20);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('20-02-1981', 'DD-MM-YYYY'), 1600, 300, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('22-02-1981', 'DD-MM-YYYY'), 1250, 500, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('02-04-1981', 'DD-MM-YYYY'), 2975, NULL, 20);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('01-05-1981', 'DD-MM-YYYY'), 2850, NULL, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('09-06-1981', 'DD-MM-YYYY'), 2450, NULL, 10);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('09-12-1982', 'DD-MM-YYYY'), 3000, NULL, 20);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('17-11-1981', 'DD-MM-YYYY'), 5000, NULL, 10);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('08-09-1981', 'DD-MM-YYYY'), 1500, NULL, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('03-12-1981', 'DD-MM-YYYY'), 950, NULL, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('03-12-1981', 'DD-MM-YYYY'), 3000, NULL, 20);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('23-01-1982', 'DD-MM-YYYY'), 1300, NULL, 10);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8000, 'ADAMS', 'CLERK', 7788, TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8001, 'BROWN', 'SALESMAN', 7698, TO_DATE('23-07-1983', 'DD-MM-YYYY'), 1350, 150, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8002, 'GREEN', 'MANAGER', 7839, TO_DATE('14-10-1984', 'DD-MM-YYYY'), 3050, NULL, 10);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8003, 'WHITE', 'CLERK', 7902, TO_DATE('11-05-1984', 'DD-MM-YYYY'), 900, NULL, 20);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8004, 'GRAY', 'SALESMAN', 7844, TO_DATE('03-03-1985', 'DD-MM-YYYY'), 1450, 200, 30);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8005, 'BLACK', 'CLERK', 7839, TO_DATE('29-08-1985', 'DD-MM-YYYY'), 1000, NULL, 10);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES (8555, 'BLACK', 'CLERK', 7839, TO_DATE('10-01-2025', 'DD-MM-YYYY'), 1000, NULL, 10);




