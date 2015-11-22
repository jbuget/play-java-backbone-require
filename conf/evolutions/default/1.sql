# Users schema

# --- !Ups

CREATE TABLE Product (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC NOT NULL,
    imageUrl VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Item (
    id INTEGER NOT NULL AUTO_INCREMENT,
    product_id INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Product (name, price, imageUrl, description) VALUES
    ('Astérix le Gaulois', 9.95, '/assets/images/alb01fr.png', '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p><p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</p><p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.</p>'),
    ('La Serpe d''or', 9.95, '/assets/images/alb02fr.png', null),
    ('Astérix et les Goths', 9.95, '/assets/images/alb03fr.png', null),
    ('Astérix Gladiateur', 9.95, '/assets/images/alb04fr.png', null),
    ('Le Tour de gaule d''Astérix', 9.95, '/assets/images/alb05fr.png', null),
    ('Astérix et Cléopâtre', 9.95, '/assets/images/alb06fr.png', null),
    ('Le Combat des chefs', 9.95, '/assets/images/alb07fr.png', null),
    ('Astérix chez les Bretons', 9.95, '/assets/images/alb08fr.png', null),
    ('Astérix et les Normands', 9.95, '/assets/images/alb09fr.png', null),
    ('Astérix Légionnaire', 9.95, '/assets/images/alb10fr.png', null),
    ('Le Bouclier arverne', 9.95, '/assets/images/alb11fr.png', null),
    ('Astérix aux jeux Olympiques', 9.95, '/assets/images/alb12fr.png', null),
    ('Astérix et le chaudron', 9.95, '/assets/images/alb13fr.png', null),
    ('Astérix en Hispanie', 9.95, '/assets/images/alb14fr.png', null),
    ('La Zizanie', 9.95, '/assets/images/alb15fr.png', null),
    ('Astérix chez les Helvètes', 9.95, '/assets/images/alb16fr.png', null),
    ('Le Domaine des dieux', 9.95, '/assets/images/alb17fr.png', null),
    ('Les lauriers de César', 9.95, '/assets/images/alb18fr.png', null),
    ('Le Devin', 9.95, '/assets/images/alb19fr.png', null),
    ('Astérix en Corse', 9.95, '/assets/images/alb20fr.png', null),
    ('Le Cadeau de César', 9.95, '/assets/images/alb21fr.png', null),
    ('La Grande Traversée', 9.95, '/assets/images/alb22fr.png', null),
    ('Obélix et Compagnie', 9.95, '/assets/images/alb23fr.png', null),
    ('Astérix chez les Belges', 9.95, '/assets/images/alb24fr.png', null),
    ('Le Grand Fossé', 9.95, '/assets/images/alb25fr.png', null),
    ('L''Odyssée d''AStérix', 9.95, '/assets/images/alb26fr.png', null),
    ('Le Fils d''Astérix', 9.95, '/assets/images/alb27fr.png', null),
    ('Astérix chez Rahazade', 9.95, '/assets/images/alb28fr.png', null),
    ('La Rose et le Glaive', 9.95, '/assets/images/alb29fr.png', null),
    ('La Galère d''Obélix', 9.95, '/assets/images/alb30fr.png', null),
    ('Astérix et Latraviata', 9.95, '/assets/images/alb31fr.png', null),
    ('Astérix et la rentrée gauloise', 9.95, '/assets/images/alb32fr.png', null),
    ('Le Ciel lui tombe sur la tête', 9.95, '/assets/images/alb33fr.png', null),
    ('L''anniversaire d''Astérix & Obélix', 9.95, '/assets/images/alb34fr.png', null),
    ('Astérix chez les Pictes', 9.95, '/assets/images/alb35fr.png', null),
    ('Le Papyrus de César', 9.95, '/assets/images/alb36fr.png', null);

# --- !Downs

DROP TABLE Product;
DROP TABLE Item;