import java.util.ArrayList;

public interface Sort {
	public <T extends Comparable <T>> void allStep(ArrayList<T> array);
	public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array);
	public <T> void toString(ArrayList<T> array);
}
