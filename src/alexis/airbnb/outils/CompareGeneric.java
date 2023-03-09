package alexis.airbnb.outils;

public class CompareGeneric <T extends CompareInterface> {

    private T obj1;
    private T obj2;

    public CompareGeneric (T obj1, T obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getHigher(){
        if (obj1.getElementToCompare() > obj2.getElementToCompare()){
            System.out.println("L'objet le plus haut est : obj1");
            return obj1;
        } else {
            System.out.println("L'objet le plus haut est : obj2");
            return obj2;
        }
    }

}
