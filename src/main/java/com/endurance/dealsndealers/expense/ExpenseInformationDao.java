package com.endurance.dealsndealers.expense;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public class ExpenseInformationDao implements IExpenseInformationDao {

    private HibernateTemplate template;

    public ExpenseInformationDao(HibernateTemplate template) {
        this.template = template;
    }


    @Override
    public List<ExpenseInformation> getExpensesOfSmb(int smbId, Date startDate, Date endDate) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ExpenseInformation.class)
                .add(Restrictions.eq("smbId", smbId))
                .add(Restrictions.between("creationDate", startDate, endDate));
        List<ExpenseInformation> result = (List<ExpenseInformation>) template.findByCriteria(criteria);
        return result;
    }

    @Override
    public List<ExpenseInformation> getExpensesForProduct(int productId, Date startDate, Date endDate) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ExpenseInformation.class)
                .add(Restrictions.eq("productId", productId))
                .add(Restrictions.between("creationDate", startDate, endDate));
        List<ExpenseInformation> result = (List<ExpenseInformation>) template.findByCriteria(criteria);
        return result;
    }

    @Override
    public void addExpenseInformation(ExpenseInformation expenseInformation) {
        template.persist(expenseInformation);
    }

    @Override
    public ExpenseInformation getExpenseInformation(int id) {
        ExpenseInformation expenseInformation = (ExpenseInformation) template.get(ExpenseInformation.class, id);
        return expenseInformation;
    }

    @Override
    public void updateExpenseInformation(ExpenseInformation expenseInformation) {
        template.update(expenseInformation);
    }

    @Override
    public void deleteExpenseInformation(ExpenseInformation expenseInformation) {
        template.delete(expenseInformation);
    }
}
