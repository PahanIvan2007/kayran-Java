INSERT INTO users (id, first_name, last_name, phone, email, username, password, role, status, created_at, updated_at) VALUES
('U000001', 'Ivan', 'Petrov', '+7-999-111-22-33', 'ivan@test.com', 'user', '$2a$10$G7gACHgiAtlfDa6WNFLFoO27/3MIzIsQ/0Rlh2B/YZQCuIbXJAjNq', 'participant', 'active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('U000002', 'Maria', 'Sidorova', '+7-999-444-55-66', 'maria@test.com', 'instructor', '$2a$10$h.MKBSTrEpfF75QcITDHAeTJGWWdmnWOuYAV5oGfLxGY42UNDfXZS', 'instructor', 'active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('U000003', 'Alexey', 'Ivanov', '+7-999-777-88-99', 'alex@test.com', 'judge', '$2a$10$m4GBwCjgy25fCYyDqJxVzuYVIdpb5wVlrVuhkFnFif3YEJRWoRwAK', 'judge', 'active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('U000004', 'Elena', 'Kozlova', '+7-999-000-11-22', 'elena@test.com', 'volunteer', '$2a$10$mXyERVHXr178X3hbvJei6ORYXGZvEZEVye627yxT5rpIJzYhceVRy', 'volunteer', 'active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('U000005', 'Dmitry', 'Sokolov', '+7-999-333-44-55', 'admin@test.com', 'admin', '$2a$10$C4RCsZzEwS7mCtL0U19EPOYGRyUIokdubnml/DGaO1.fB2Jml4zn2', 'system_admin', 'active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO points (id, title, type, address, lat, lng, status, created_at) VALUES
('P000001', 'Voronezh Water Base', 'base', 'Voronezh, Vodnaya st. 1', 51.6536, 39.2174, 'active', CURRENT_TIMESTAMP),
('P000002', 'Don Kayak Club', 'franchise', 'Voronezh region, Semiluki', 51.6900, 39.0200, 'active', CURRENT_TIMESTAMP);

INSERT INTO boats (id, point_id, serial_number, color, boat_type, capacity, status, created_at) VALUES
('B000001', 'P000001', 'KAYAK-RED-001', 'Red', 'Kayak', 1, 'available', CURRENT_TIMESTAMP),
('B000002', 'P000001', 'KAYAK-BLU-002', 'Blue', 'Kayak', 1, 'available', CURRENT_TIMESTAMP),
('B000003', 'P000001', 'CANOE-GRN-003', 'Green', 'Canoe', 2, 'available', CURRENT_TIMESTAMP),
('B000004', 'P000002', 'SUP-ORG-004', 'Orange', 'SUP', 1, 'available', CURRENT_TIMESTAMP),
('B000005', 'P000002', 'KAYAK-YEL-005', 'Yellow', 'Kayak', 1, 'rented', CURRENT_TIMESTAMP);

INSERT INTO events (id, event_type, title, description, start_time, end_time, point_id, created_by, status, created_at, updated_at) VALUES
('E000001', 'rental', 'Kayak Rental', 'Lake trip', CURRENT_TIMESTAMP, DATEADD('HOUR', 3, CURRENT_TIMESTAMP), 'P000001', 'U000001', 'active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('E000002', 'training', 'Beginners Training', 'Basic paddling skills', DATEADD('DAY', 1, CURRENT_TIMESTAMP), DATEADD('DAY', 1, DATEADD('HOUR', 4, CURRENT_TIMESTAMP)), 'P000001', 'U000002', 'planned', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('E000003', 'route', 'Don River Route', 'Group trip 15km', DATEADD('DAY', 2, CURRENT_TIMESTAMP), DATEADD('DAY', 2, DATEADD('HOUR', 6, CURRENT_TIMESTAMP)), 'P000002', 'U000002', 'planned', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('E000004', 'festival', 'Water Sports Festival', 'Annual festival with competitions', DATEADD('DAY', 14, CURRENT_TIMESTAMP), DATEADD('DAY', 16, CURRENT_TIMESTAMP), 'P000001', 'U000005', 'planned', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('E000005', 'match', 'Canoe Polo Cup', 'Semi-final match', DATEADD('DAY', 3, CURRENT_TIMESTAMP), DATEADD('DAY', 3, DATEADD('HOUR', 2, CURRENT_TIMESTAMP)), 'P000001', 'U000003', 'planned', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rentals (id, event_id, user_id, boat_id, start_time, status, created_at) VALUES
('R000001', 'E000001', 'U000001', 'B000001', CURRENT_TIMESTAMP, 'active', CURRENT_TIMESTAMP);

INSERT INTO routes (id, title, description, difficulty, distance_km, estimated_duration_min, route_type, status, created_at) VALUES
('RTE001', 'Lake Circuit', 'Easy route around the lake', 'easy', 5.0, 90, 'circular', 'active', CURRENT_TIMESTAMP),
('RTE002', 'Don Downstream', 'Medium difficulty downstream route', 'medium', 15.0, 180, 'linear', 'active', CURRENT_TIMESTAMP),
('RTE003', 'Adaptive Shore Route', 'Accessible route for inclusive programs', 'adaptive', 2.0, 60, 'out-and-back', 'active', CURRENT_TIMESTAMP);

INSERT INTO route_points (id, route_id, order_index, lat, lng, title, checkpoint_type) VALUES
('RP001', 'RTE001', 1, 51.6536, 39.2174, 'Start - Main Pier', 'start'),
('RP002', 'RTE001', 2, 51.6600, 39.2200, 'North Shore Point', 'waypoint'),
('RP003', 'RTE001', 3, 51.6480, 39.2150, 'South Beach', 'waypoint'),
('RP004', 'RTE001', 4, 51.6536, 39.2174, 'Finish - Main Pier', 'finish'),
('RP005', 'RTE002', 1, 51.6900, 39.0200, 'Club Launch', 'start'),
('RP006', 'RTE002', 2, 51.6700, 39.0500, 'Old Mill', 'waypoint'),
('RP007', 'RTE002', 3, 51.6500, 39.0800, 'Forest Bend', 'waypoint'),
('RP008', 'RTE002', 4, 51.6300, 39.1100, 'Finish Beach', 'finish');

INSERT INTO teams (id, title, captain_user_id, status, created_at) VALUES
('TM001', 'Dolphins', 'U000001', 'active', CURRENT_TIMESTAMP),
('TM002', 'Otters', 'U000004', 'active', CURRENT_TIMESTAMP);

INSERT INTO tournaments (id, event_id, title, format, status, created_at) VALUES
('TNT001', 'E000005', 'Canoe Polo Championship 2026', 'playoff', 'active', CURRENT_TIMESTAMP);

INSERT INTO matches (id, event_id, tournament_id, team_a_id, team_b_id, judge_user_id, start_time, status, created_at) VALUES
('MCH001', 'E000005', 'TNT001', 'TM001', 'TM002', 'U000003', DATEADD('DAY', 3, CURRENT_TIMESTAMP), 'planned', CURRENT_TIMESTAMP);

INSERT INTO inclusive_profiles (id, user_id, health_restrictions, allowed_load_level, accessibility_needs, training_level, created_at, updated_at) VALUES
('INC001', 'U000004', 'Limited mobility in legs', 'low', 'Requires adaptive boat seat', 'beginner', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
