/*
 Base de données de test.
 */
ALTER USER postgres WITH PASSWORD 'password';

DROP TABLE IF EXISTS stories;

CREATE TABLE stories(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    creation_date TIMESTAMP,
    last_edit_date TIMESTAMP,
    visible boolean);

INSERT INTO stories(title, content, creation_date, last_edit_date, visible)
VALUES
('Test', 'Proin ut lorem vitae diam iaculis sagittis. Phasellus bibendum felis sit amet ante porta, vitae iaculis lacus malesuada. Phasellus pharetra urna tristique neque cursus, non facilisis ligula auctor. Nulla eget nunc et leo molestie blandit. Morbi vitae tellus ipsum. Sed magna magna, facilisis nec elementum vitae, malesuada ac ligula. Proin non lacus nec velit congue iaculis rhoncus posuere est. In egestas ex vitae condimentum semper. Maecenas rutrum risus vitae neque accumsan ullamcorper. Duis nisi nisi, imperdiet non tincidunt condimentum, vestibulum et velit. Etiam tellus purus, ullamcorper eget maximus sit amet, semper eu felis. Vestibulum vitae aliquam enim. Morbi condimentum massa quis velit euismod aliquet. Phasellus varius nisi a eros tristique, id cursus arcu venenatis. Aenean tincidunt, velit non ullamcorper commodo, massa est ullamcorper dui, id rhoncus felis est in nisi. Nunc at blandit sapien.
lus faucibus dolor sit amet nisi bibendum, et venenatis mi interdum. Aenean faucibus ornare gravida. Nulla mollis vel nulla a dictum. Aenean id porttitor ante. Nullam a sem nec elit vulputate tempus. Curabitur nec libero arcu. Duis neque urna, porttitor vel quam vitae, porttitor bibendum turpis. Phasellus vehicula fringilla mollis. Nunc in aliquam nisl, et placerat nibh. Cras a molestie augue.
natis. Curabitur porttitor vel lorem ut feugiat. Donec ut velit consequat ipsum egestas mattis nec aliquet purus. Donec convallis nec nisi et porttitor. Duis et tincidunt nibh. Nullam tempor dolor at risus iaculis placerat. Nunc vel nunc eget ligula sagittis vehicula. Proin sed porta ante, a suscipit odio. Pellentesque finibus tortor eget faucibus gravida. Proin vitae lorem lectus. Aenean ornare in lacus quis molestie. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
tincidunt bibendum tincidunt.', NOW(), NOW(), true) ,

('Test2', 'Ut ipsum quam, maximus sed vehicula nec, dictum in orci. Fusce sit amet lectus ut purus sagittis consectetur. Curabitur a erat dolor. Vestibulum eget neque sed orci scelerisque semper vel quis risus. Nullam quis auctor dolor. Mauris euismod semper interdum. In urna nisl, lobortis nec enim dignissim, rhoncus elementum ex. Donec sit amet libero varius, porttitor mauris ac, tincidunt augue. Proin enim mauris, posuere non mauris sed, porta ultrices mi. Integer nec leo ligula. Suspendisse eu nibh pulvinar, scelerisque lorem in, congue massa. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus velit lacus, elementum vitae risus non, sodales pretium eros. Etiam elit dui, varius nec mauris vel, porta cursus tortor.

Phasellus iaculis luctus felis, sed pulvinar purus auctor id. Curabitur in sollicitudin diam, at mollis ligula. Vestibulum faucibus ut libero eget dictum. Nunc vel rutrum velit. Aenean ultrices sodales mauris, sit amet commodo felis rhoncus mattis. Ut auctor venenatis odio, ac suscipit velit gravida non. Sed eleifend hendrerit purus, a pharetra quam vulputate at.

Nullam mollis elit sit amet hendrerit lacinia. Pellentesque interdum tellus lorem, vitae fermentum tortor facilisis sit amet. Aliquam vestibulum faucibus augue id congue. In finibus elit justo, quis condimentum augue pulvinar a. Pellentesque eu purus vestibulum, semper nisl eget, vehicula diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam tincidunt ante ut gravida efficitur. Integer porta felis dapibus, dapibus eros vitae, euismod erat. Sed feugiat enim sed magna luctus, eget congue justo faucibus. Vivamus at dignissim urna, vel congue odio. Integer pretium sit amet nisi eget suscipit. In eu scelerisque enim. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam efficitur ligula nibh, et porta turpis blandit id. Integer laoreet odio purus, non molestie elit vehicula eget. Duis sem mi, ultrices sit amet risus a, euismod porttitor metus.

 duis.', NOW(), NOW(), true);