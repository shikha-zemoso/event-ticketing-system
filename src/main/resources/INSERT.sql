INSERT INTO Venue (id, venue_name, venue_location, seating_capacity)
VALUES (1, 'Concert Hall', 'City Center', 1000),
       (2, 'Sports Arena', 'Sports Complex', 5000),
       (3, 'Theater', 'Downtown', 800);

INSERT INTO Event (id, event_name, event_date, event_description, venue_id)
VALUES (1, 'Music Concert', '2023-07-31', 'An awesome music concert with top artists.', 1),
       (2, 'Sports Tournament', '2023-08-15', 'A thrilling sports tournament with various games.', 2),
       (3, 'Theater Play', '2023-09-10', 'A captivating theater play with talented actors.', 3);

INSERT INTO Ticket (id, event_id, ticket_price, ticket_type, ticket_quantity)
VALUES (1, 1, 50.00, 'General', 200),
       (2, 1, 75.00, 'VIP', 50),
       (3, 2, 100.00, 'Regular', 100),
       (4, 2, 150.00, 'Premium', 20),
       (5, 3, 30.00, 'Standard', 300),
       (6, 3, 50.00, 'Premium', 100);

INSERT INTO User (id, user_name, user_email, user_phone)
VALUES (1, 'John Doe', 'john.doe@example.com', '123-456-7890'),
       (2, 'Jane Smith', 'jane.smith@example.com', '987-654-3210'),
       (3, 'Mike Johnson', 'mike.johnson@example.com', '111-222-3333');

INSERT INTO Seat (event_id, seat_number, is_booked)
VALUES (1, 1, false),
       (1, 2, true),
       (1, 3, false),
       (2, 1, false),
       (2, 2, true),
       (2, 3, false),
       (2, 4, false),
       (3, 1, true),
       (3, 2, false),
       (3, 3, false);
