SET foreign_key_checks=1;

USE pegasusdb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('yamada@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description)VALUES
('ケーキ', 'ケーキのカテゴリーです'),
('焼き菓子', '焼き菓子のカテゴリーです'),
('和菓子', '和菓子のカテゴリーです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES 
('モンブラン','もんぶらん','国産の栗を使った贅沢モンブラン。幅広い年齢層のお客様に人気です。',1,550,'/img/MontBlanc.jpg','2023/09/12','株式会社Pegasus'),
('ロールケーキ','ろーるけーき','甘さ控えめの生クリームをふんわり生地で包みました。',1,300,'/img/RollCake.jpg','2023/09/12','株式会社Pegasus'),
('チーズケーキ','ちーずけーき','フランス産クリームチーズを使用。濃厚なチーズの風味が味わえます。',1,450,'/img/CheeseCake.jpg','2023/09/12','株式会社Pegasus'),
('クッキー','くっきー','こだわりのクッキーをぎゅっと詰め合わせたクッキー缶。贈り物にもぴったりです。',2,1200,'/img/Cookie.jpg','2023/09/12','株式会社Pegasus'),
('マドレーヌ','まどれーぬ','国産バターを使用し、しっとりと焼き上げました。',2,200,'/img/Madeleine.jpg','2023/09/12','株式会社Pegasus'),
('マカロン','まかろん','外はサクサク、中はしっとりと贅沢な口溶け。',2,150,'/img/Macaron.jpg','2023/09/12','株式会社Pegasus'),
('羊羹','ようかん','小豆の豊かな風味を生かし、上品な味わいに仕上げました。',3,800,'/img/Yokan.jpg','2023/09/12','株式会社Pegasus'),
('どら焼き','どらやき','こだわりの自家製の餡としっとりとした皮。どこか懐かしい味わいです。',3,150,'/img/Dorayaki.jpg','2023/09/12','株式会社Pegasus'),
('大福','だいふく','やわらかいお餅に、北海道産の小豆あんをたっぷり包みました。',3,150,'/img/Daifuku.jpg','2023/09/12','株式会社Pegasus');

