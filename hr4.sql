CREATE TABLE department_test (
    d_id NUMBER PRIMARY KEY,
    d_name VARCHAR2(100)
);

CREATE TABLE student (
    s_id NUMBER PRIMARY KEY,
    s_name VARCHAR2(50),
    address VARCHAR2(50),
    age NUMBER,
    joined_date DATE,
    d_id NUMBER,
    CONSTRAINT fk_department FOREIGN KEY (d_id) REFERENCES department_test(d_id)
);

INSERT INTO department_test (d_id, d_name) VALUES (1, 'Computer Science');
INSERT INTO department_test (d_id, d_name) VALUES (2, 'Information Systems');
INSERT INTO department_test (d_id, d_name) VALUES (3, 'Software Engineering');
COMMIT;

INSERT INTO student (s_id, s_name, address, age, joined_date, d_id)
VALUES (1, 'Ahmed Ali', 'Cairo', 20, TO_DATE('2022-09-15', 'YYYY-MM-DD'), 1);

INSERT INTO student (s_id, s_name, address, age, joined_date, d_id)
VALUES (2, 'Sara Mohamed', 'Giza', 21, TO_DATE('2023-02-10', 'YYYY-MM-DD'), 2);

INSERT INTO student (s_id, s_name, address, age, joined_date, d_id)
VALUES (3, 'Mona Tarek', 'Alexandria', 22, TO_DATE('2021-11-01', 'YYYY-MM-DD'), 3);

INSERT INTO student (s_id, s_name, address, age, joined_date, d_id)
VALUES (4, 'Youssef Nabil', 'Mansoura', 19, TO_DATE('2024-01-20', 'YYYY-MM-DD'), 1);
COMMIT;

SELECT * FROM student;
SELECT * FROM department_test;

COMMIT;
