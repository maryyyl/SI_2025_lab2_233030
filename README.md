Марија Коцевска 233030
2. link до CFG https://app.diagrams.net/#G1upWTHCP3N_O5nIjhEMtNcQXzOWt77sso#%7B%22pageId%22%3A%226bZe4TaPM3vWA2CiTnFE%22%7D


3.
Цикломатска комплексност, е 8, затоа што има 7 предикатни јазли, означени со зелена боја на цртежот, а равенката вели
Cx = nP + 1
Cx - цикломатска комплексност
nP - број на предикатни јазли
Cx = 7 + 1 = 8

4.
Every statement:
Минимален број на тест случаи е 5 за да може да се тестира секоја линија код во функцијата, и тоа следните тест случаи:
Слика EveryStatement.png поставено е за секоја линија код *, ако се извршува со тој тест случај, или е празно ако не се извршува, бројките соодветствуваат со бројката подолу:
1*: 
   checkCart(allItems,"neverMind"); //allItems=null
2*: 
   allItems1.add(new SILab2.Item("someName",1,301,1));
   allItems1.add(new SILab2.Item(null,0,0,0));
   checkCart(allItems1,"neverMind);
3*:
  allItems2.add(new SILab2.Item("someName",1,301,1));
  allItems2.add(new SILab2.Item("someName",0,0,0));
  checkCart(allItems2,"123456791234567");
4*:
   allItems2.add(new SILab2.Item("someName",1,301,1));
   allItems2.add(new SILab2.Item("someName",0,0,0));
   checkCart(allItems2,"12345679123456"); // invalid length of cardNumber
5*: 
   allItems2.add(new SILab2.Item("someName",1,301,1));
   allItems2.add(new SILab2.Item("someName",0,0,0));
   checkCart(allItems2,"1a3456791234567"); //valid length, invalid character in cardNumber

5. Multiple condition 
if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
1: FFF - False
2: TXX - True (TFF,TFT,TTF,TTT)
3: FTX - True (FTF,FTT)
4: FFT - True
Доволно е само една листа со 4 различни Items, во 4 различни итерации од циклусот различно ќе се евалуира if условот
test Case 1: 
(name,quantity,price,discount)
List<SILab2.Item> allItems= new ArrayList<>();
allItems.add(new SILab2.Item("someName",1,299,0)); - FFF
allItems.add(new SILab2.Item("someName",1,301,1)); - TTF (TXX)
allItems.add(new SILab2.Item("someName",1,299,0.10)); - FTF
allItems.add(new SILab2.Item("someName",11,299,0)); - FFT
checkCart(allItems,"1234567891234567")) 
