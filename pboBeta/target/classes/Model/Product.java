    package Model;

    public abstract class Product {
        protected int id;
        protected String category;
        protected String name;
        protected double price;
        protected String description;

        public Product(int id,String category, String name, double price, String description) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.price = price;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }
        
        public abstract String getDetails();
    }
