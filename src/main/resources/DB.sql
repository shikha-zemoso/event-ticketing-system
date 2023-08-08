CREATE TABLE Venue (
                       id INT PRIMARY KEY,
                       venue_name VARCHAR(255),
                       venue_location VARCHAR(255),
                       seating_capacity INT
);

CREATE TABLE Event (
                       id INT PRIMARY KEY,
                       event_name VARCHAR(255),
                       event_date DATE,
                       event_description TEXT,
                       venue_id INT,
                       FOREIGN KEY (venue_id) REFERENCES Venue(id)
);


CREATE TABLE Ticket (
                        id INT PRIMARY KEY,
                        event_id INT NOT NULL,
                        ticket_price DECIMAL(10, 2) NOT NULL,
                        ticket_type VARCHAR(50) NOT NULL,
                        ticket_quantity INT NOT NULL,
                        FOREIGN KEY (event_id) REFERENCES Event(id)
);

CREATE TABLE User (
                      id INT PRIMARY KEY,
                      user_name VARCHAR(255) NOT NULL,
                      user_email VARCHAR(255) NOT NULL,
                      user_phone VARCHAR(20) NOT NULL
);

CREATE TABLE Purchase (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id INT,
                          ticket_id INT,
                          purchase_date DATE,
                          purchase_quantity INT,
                          FOREIGN KEY (user_id) REFERENCES User(id),
                          FOREIGN KEY (ticket_id) REFERENCES Ticket(id)
);

CREATE TABLE Seat (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      event_id INT NOT NULL,
                      seat_number INT NOT NULL,
                      is_booked BOOLEAN NOT NULL,
                      FOREIGN KEY (event_id) REFERENCES Event(id)
);

CREATE TABLE Waiting_List (
                             id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             user_id INT NOT NULL,
                             event_id INT NOT NULL,
                             join_date DATE NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES User(id),
                             FOREIGN KEY (event_id) REFERENCES Event(id)
);
