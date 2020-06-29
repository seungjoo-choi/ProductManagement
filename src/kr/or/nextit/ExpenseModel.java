package kr.or.nextit;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExpenseModel {

	private StringProperty expenseList;
	private IntegerProperty expenseQuantity;
	private IntegerProperty expenseCost;
	
	
	
	public ExpenseModel(String expenseList, int expenseQuantity, int expenseCost) {
		super();
		this.expenseList = new SimpleStringProperty(expenseList);
		this.expenseQuantity = new SimpleIntegerProperty(expenseQuantity);
		this.expenseCost = new SimpleIntegerProperty(expenseCost);
	}

	public final StringProperty expenseListProperty() {
		return this.expenseList;
	}
	
	public final String getExpenseList() {
		return this.expenseListProperty().get();
	}
	
	public final void setExpenseList(final String expenseList) {
		this.expenseListProperty().set(expenseList);
	}
	
	public final IntegerProperty expenseQuantityProperty() {
		return this.expenseQuantity;
	}
	
	public final int getExpenseQuantity() {
		return this.expenseQuantityProperty().get();
	}
	
	public final void setExpenseQuantity(final int expenseQuantity) {
		this.expenseQuantityProperty().set(expenseQuantity);
	}
	
	public final IntegerProperty expenseCostProperty() {
		return this.expenseCost;
	}
	
	public final int getExpenseCost() {
		return this.expenseCostProperty().get();
	}
	
	public final void setExpenseCost(final int expenseCost) {
		this.expenseCostProperty().set(expenseCost);
	}
	

}
