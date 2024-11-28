-- Insert random data into the military_ranks table
-- Insert or update record in military_branches table
INSERT INTO military_branches (id, name)
VALUES (1, 'Στρατός Ξηράς')
ON DUPLICATE KEY UPDATE name = 'Στρατός Ξηράς';

INSERT INTO military_branches (id, name)
VALUES (2, 'Πολεμικό Ναυτικό')
ON DUPLICATE KEY UPDATE name = 'Πολεμικό Ναυτικό';

INSERT INTO military_branches (id, name)
VALUES (3, 'Πολεμική Αεροπορία')
ON DUPLICATE KEY UPDATE name = 'Πολεμική Αεροπορία';

-- Insert random data into the military_ranks table
INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (1, 'ID', 'Ιδιώτης', 1)  -- Army: Private
ON DUPLICATE KEY UPDATE abbreviation = 'ID', name = 'Ιδιώτης';

INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (2, 'ΛΟΧΓΟΣ', 'Λοχίας', 1)  -- Army: Sergeant
ON DUPLICATE KEY UPDATE abbreviation = 'LOX', name = 'Λοχίας';

INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (3, 'ΥΠΟΛΓΟΣ', 'Υπολοχαγός', 1)  -- Army: Lieutenant
ON DUPLICATE KEY UPDATE abbreviation = 'YPOL', name = 'Υπολοχαγός';

INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (4, 'LOCH', 'Λοχαγός', 1)  -- Army: Captain
ON DUPLICATE KEY UPDATE abbreviation = 'LOCH', name = 'Λοχαγός';

INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (5, 'ΤΓΜΤΧΗΣ', 'Ταγματάρχης', 1)  -- Army: Major
ON DUPLICATE KEY UPDATE abbreviation = 'TAX', name = 'Ταγματάρχης';

INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (6, 'ΣΧΗΣ', 'Συνταγματάρχης', 1)  -- Army: Colonel
ON DUPLICATE KEY UPDATE abbreviation = 'SYN', name = 'Συνταγματάρχης';

INSERT INTO military_ranks (id, abbreviation, name, branch_id)
VALUES (7, 'ΤΑΞ', 'Ταξίαρχος', 1)  -- Army: Brigadier General
ON DUPLICATE KEY UPDATE abbreviation = 'TAX', name = 'Ταξίαρχος';



-- Insert random data into the military_units table

-- Army Units
INSERT INTO military_units (abbreviation, name, branch_id) VALUES ('ΝΟΜ', 'Νομικό Σώμα', 1);  -- Army: Infantry

-- Inserting or updating data into declaration_months table
INSERT INTO declaration_months (id, is_active, max_month_declaration, tmhmatarxhs_active_date, users_active_date, month, year)
VALUES
(1, 1, 15, '2024-12-17 00:00:00', '2024-11-15 00:00:00', '11', 2024)
ON DUPLICATE KEY UPDATE
is_active = 1,
max_month_declaration = 15,
tmhmatarxhs_active_date = '2024-12-17 00:00:00',
users_active_date = '2024-11-15 00:00:00',
month = 'Νοέμβριος',
year = 2024;

-- Second record
INSERT INTO declaration_months (id, is_active, max_month_declaration, tmhmatarxhs_active_date, users_active_date, month, year)
VALUES
(2, 1, 15, '2024-12-17 00:00:00', '2024-12-15 00:00:00', '12', 2024)
ON DUPLICATE KEY UPDATE
is_active = 1,
max_month_declaration = 15,
tmhmatarxhs_active_date = '2024-12-17 00:00:00',
users_active_date = '2024-12-15 00:00:00',
month = 'Δεκέμβριος',
year = 2024;

-- Insert the first record for ΣΥ Αττικής with id 241
INSERT INTO stratologika_grafeia (id, sg_name)
VALUES
(1, 'A ΔΣΥ'),
(2,'Β ΔΣΥ'),
(100, 'Μ/Κ Στρατολογίας'),
(241, 'ΣΥ Αττικής'),
(253,'Δυτικής Αττικής');


INSERT INTO users (name, kvd_sg, rank_id, unit_id, role, username, password)
VALUES
('Αλέξανδρος Παπαδόπουλος', 1, 2, 1, 'USER', 'user1', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Μαρία Καραγιάννη', 2, 2, 3, 'ADMIN', 'user2', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Γιώργος Σταματόπουλος', 100, 3, 1, 'USER', 'user3', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Ελένη Μιχαηλίδου', 241, 1, 1, 'SUPER_ADMIN', 'user4', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Νίκος Παπανικολάου', 253, 1, 1, 'USER', 'user5', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Σοφία Παπαϊωάννου', 1, 3, 5, 'ADMIN', 'user6', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Ανδρέας Καλοχριστιανίδης', 2, 2, 1, 'USER', 'user7', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Παναγιώτης Κωνσταντίνου', 100, 3, 1, 'SUPER_ADMIN', 'user8', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Κωνσταντίνος Γεωργίου', 241, 1, 1, 'USER', 'user9', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Δήμητρα Βασιλείου', 253, 2, 3, 'ADMIN', 'user10', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Στυλιανός Χριστοδούλου', 1, 3, 1, 'USER', 'user11', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Άννα Αλεξίου', 2, 2, 5, 'SUPER_ADMIN', 'user12', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Μιχάλης Σιδέρης', 100, 1, 1, 'USER', 'user13', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Νικόλαος Παπαγιαννόπουλος', 241, 2, 1, 'ADMIN', 'user14', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm'),
('Αθηνά Καραμούζη', 253, 3, 1, 'USER', 'user15', '$2a$10$5rAuiya2a4IjPKtXuCu.y.l3Z4muhtecPAm9MGFykzNJ.ffVO1tsm');
