package ro.zynk.futureup.controllers.responses;

public class TotalValueOfWalletResponse extends BaseResponse{
    private float totalValue;

    public TotalValueOfWalletResponse(float totalValue) {
        this.totalValue = totalValue;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }
}
