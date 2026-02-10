package stock_price_fluctuation;

public class Main {
    public static void main(String[] args) throws Exception {
        new StockPriceRunner().run(
                "src/stock_price_fluctuation/example_input.txt",
                "src/stock_price_fluctuation/example_output.txt"
        );
    }
}
