/**
 * Conceito de classes em Dart
 * Modelagem de Conceitual
 * Prof. Ms. Paulo Barreto
 * Data 22/04/2021
 */
class Product {
  //Atributos com nível de privacidade privada
  int _id;
  String _title;
  bool _active;
  double _price;
  int valorPub;
  int unidades;
  
  //Método construtor
  //Definição de função via construtor
  Product(this._id, this._title, this._active, this._price);
  
  //Definição de função via getter
  int get id => _id;  
  String get title => _title;  
  bool get active => _active;  
  double get price => _price;
  
  String toString(){
    return "Titulo: " + _title + " Preço: " + price.toString();
  }
}

//Carrinho de Compras
class ShoppingCart {
  //Declaração da collection List de Produtos
  List<Product> _products = [];
  //Método getter para poder retornar os conteúdos do list
  List<Product> get products => this._products;

  void addItem(Product product){
    this.products.add(product);
  }

  double total() {
    double total = 0;
    this.products.forEach((Product p) {
      total += p.price * (p.unidades ?? 1);
    });
    return total;
  }
}

main() {
  final shopping = new ShoppingCart();

  //o uso da palavra reservada new é opicional a partir da DART 2.0
  //e não usaremos nas próximas linhas
  final pen = new Product(1, "Caneta", true, 4.75);
  shopping.addItem(pen);

  final pencil = new Product(2, "Lápis", false, 1.25);
  shopping.addItem(pencil);
  print(pencil.toString());
  pencil.unidades = 10;
  
  final book = new Product(3, "Livro Texto", false, 103.25);
  shopping.addItem(book);
  book.unidades = 10;

  print("Total da compra: ${shopping.total()}");
}