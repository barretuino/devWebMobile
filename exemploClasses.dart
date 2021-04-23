/**
    IDE DART --> https://dartpad.dartlang.org/
**/
/**
    Exemplo de uma classe em DART
    Prof. Ms. Paulo Barreto
    Data 22/04/2021    
**/
class Product {
  //Atributos com nível de privacidade privada
  int _id;
  String _title;
  bool _active;
  double _price;

  //Definição de função via construtor
  Product(this._title, this._active, this._price);

  //Definição de função via getter
  int get id => _id;

  double get price => _price;

  bool get active => _active;

  String get title => _title;
}

/**
    Exemplo de Carrinho de Compras
    Prof. Ms. Paulo Barreto
    Data 22/04/2021   
**/
class ShoppingCart {
  List<Product> _products = [];
  List<Product> get products => this._products;

  void addItem(Product product){
    this.products.add(product);
  }

  double total() {
    double total = 0;

    this.products.forEach((Product p) {
      total += p.price;
    });

    return total;
  }
}

/**
    Exemplo de Execução
    Prof. Ms. Paulo Barreto
    Data 22/04/2021   
**/
main() {
  final shopping = new ShoppingCart();

  //o uso da palavra reservada new é opicional a partir da DART 2.0
  //e não usaremos nas próximas linhas
  final pen = Product("Caneta", true, 4.75);
  shopping.addItem(pen);

  final pencil = Product("Lápis", false, 1.25);
  shopping.addItem(pencil);

  print("Total da compra: ${shopping.total()}");
}

/**
    Exemplo de Execução
    Prof. Ms. Paulo Barreto
    Data 22/04/2021   
**/
main() {
  final shopping = new ShoppingCart();

  //o uso da palavra reservada new é opcional a partir da DART 2.0
  //e não usaremos nas próximas linhas
  final pen = Product("Caneta", true, 4.75);
  shopping.addItem(pen);

  final pencil = Product("Lápis", false, 1.25);
  shopping.addItem(pencil);

  print("Total da compra: ${shopping.total()}");
}

class Product {
  //Comentário
  //Atributos com nível de privacidade privada
  int _id;
  String _title;
  bool _active;
  double _price;

  //Definição de função via construtor
  Product(this._title, this._active, this._price);

  //Definição de função via getter
  int get id => _id;

  double get price => _price;

  bool get active => _active;

  String get title => _title;
}

class ShoppingCart {
  List<Product> _products = [];
  List<Product> get products => this._products;

  void addItem(Product product){
    this.products.add(product);
  }

  double total() {
    double total = 0;

    this.products.forEach((Product p) {
      total += p.price;
    });

    return total;
  }
}
