-- Insert sample roles
INSERT INTO role (id, name) VALUES
(1, 'seller'),
(2, 'buyer');

-- Insert sample users with roles
INSERT INTO user (id, username, password) VALUES
(1, 'john_doe', '$2a$10$QvczlBgmQ.zkM3kOa/yBQe1SFnOWY0pLJpLAPfw2xXN2Y3X5ftXje'), -- Password: password
(2, 'jane_smith', '$2a$10$QvczlBgmQ.zkM3kOa/yBQe1SFnOWY0pLJpLAPfw2xXN2Y3X5ftXje'); -- Password: password

-- Assign roles to users
INSERT INTO user_role (user_id, role_id) VALUES
(1, 1), -- John Doe is a seller
(2, 2); -- Jane Smith is a buyer
