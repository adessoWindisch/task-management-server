INSERT INTO employee (org_id, first_name, last_name, email, mobile_number, created_at, created_by) VALUES ('ORG1', 'Sascha', 'Windisch', 's.w@a.de', '1234567890', '2024-07-07', 'admin');
INSERT INTO employee (org_id, first_name, last_name, email, mobile_number, created_at, created_by) VALUES ('ORG1', 'Max', 'Mustermann', 'm.m@a.de', '0987654321', '2024-07-07', 'admin');

INSERT INTO tasks (employee_id, type, description, status, priority, start_date, end_date, created_at, created_by) VALUES (1, 'Development', 'Develop a new feature', 'OPEN', 'HIGH', '2024-07-07', '2024-07-14', '2024-07-07', 'admin');
INSERT INTO tasks (employee_id, type, description, status, priority, start_date, end_date, created_at, created_by) VALUES (1, 'Testing', 'Test the new feature', 'OPEN', 'MEDIUM', '2024-07-15', '2024-07-21', '2024-07-07', 'admin');
INSERT INTO tasks (employee_id, type, description, status, priority, start_date, end_date, created_at, created_by) VALUES (2, 'Development', 'Develop a new feature', 'OPEN', 'HIGH', '2024-07-07', '2024-07-14', '2024-07-07', 'admin');

