package InterfaceAndAbstExercise.CollectionHierrarchy;

public class AddRemovableCollection extends Collection implements AddRemove {


    @Override
    public String remove() {
        int lastElementIndex = super.getItems().size() - 1;
       return super.getItems().remove(lastElementIndex);

    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }
}
