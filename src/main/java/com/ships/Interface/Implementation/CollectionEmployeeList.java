package com.ships.Interface.Implementation;

import com.ships.Interface.EmployeeList;
import com.ships.Objects.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by admin on 14.04.17.
 */
public class CollectionEmployeeList implements EmployeeList{
    private ObservableList<Employee> errorCollection = FXCollections.observableArrayList();

    @Override
    public void add(Employee emp) {
        errorCollection.add(emp);
    }

    @Override
    public void delete(Employee emp) {
        errorCollection.remove(emp);
    }

    @Override
    public void update(Employee emp) {

    }
    //@XmlElement(name = "Error")
    public ObservableList<Employee> getCollection() {
        return errorCollection;
    }
    //    public MyError getError(int i){
//        errorCollection.get()
//    }
    public void setCollection(ObservableList<Employee> collection) {
        this.errorCollection = collection;
    }

    public void fillTestData(){
        this.errorCollection.add(new Employee("admin","admin", "pipichindreks.xxx@gmail.com", true));
        this.errorCollection.add(new Employee("alex","shalin", "shalin222@meta.ua", false));
        this.errorCollection.add(new Employee("ivan","ivan", "pipichindreks@yandex.ru", true));
        this.errorCollection.add(new Employee("jdm","jdm", "dinnhalll123@gmail.com", false));
    }

    public void printCollection(){

        for (Employee temp: errorCollection) {
            temp.toString();
        }
    }
}


