-- Create places table with standard PostgreSQL column naming convention (snake_case)
CREATE TABLE travel_journal_schema.places (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    location VARCHAR(100) NOT NULL,
    google_maps_url VARCHAR(500),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    description TEXT,
    image_url VARCHAR(500),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    version BIGINT DEFAULT 0
);