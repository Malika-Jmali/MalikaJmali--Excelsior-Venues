SELECT venue.name, venue.description, city.name, city.state_abbreviation, category.name
FROM category
JOIN category_venue ON category_venue.category_id = category.id
JOIN venue ON venue.id = category_venue.venue_id
JOIN city ON city.id = venue.city_id
WHERE venue.id = category_venue.venue_id;

