package com.hexaware.ftp88.model;

import com.hexaware.ftp88.persistence.DbConnection;
import com.hexaware.ftp88.persistence.EmployeeDAO;

import java.util.Date;
import java.util.Objects;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;
  private String ename;
  private String empPhone;
  private String empEmail;
  private String empDept;
  private Date empJoinDate;
  private int empMgrId;
  private int empLeaveBal;
  /**
   * default constructor.
   */
  public Employee() {

  }



  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(ename, emp.ename) && Objects.equals(empPhone, emp.empPhone)
        && Objects.equals(empEmail, emp.empEmail) && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empJoinDate, emp.empJoinDate) && Objects.equals(empMgrId, emp.empMgrId)
        && Objects.equals(empLeaveBal, emp.empLeaveBal)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, ename, empPhone, empEmail, empDept, empDept, empJoinDate, empMgrId, empLeaveBal);
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEname to initialize employee id.
   * @param argPhone to initialize employee id.
   * @param argEmail to initialize employee id.
   * @param argDept to initialize employee id.
   * @param argDate to initialize employee id.
   * @param argEmpMgrId to initialize employee id.
   * @param argLeaveBal to initialize employee id.
  */
  public Employee(final int argEmpId, final String argEname, final String argPhone, final String argEmail,
        final String argDept, final Date argDate, final int argEmpMgrId,
        final int argLeaveBal) {
    this.empId = argEmpId;
    this.ename = argEname;
    this.empPhone = argPhone;
    this.empEmail = argEmail;
    this.empDept = argDept;
    this.empJoinDate = argDate;
    this.empMgrId = argEmpMgrId;
    this.empLeaveBal = argLeaveBal;

  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEname() {
    return ename;
  }
  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone.
   */
  public final String getPhone() {
    return empPhone;
  }
  /**
   * Gets the Employee Email.
   * @return this Employee's Email.
   */
  public final String getEmail() {
    return empEmail;
  }
   /**
   * Gets the Employee Dept.
   * @return this Employee's Dept.
   */
  public final String getDept() {
    return empDept;
  }
  /**
   * Gets the Employee join date.
   * @return this Employee's join date.
   */
  public final Date getDate() {
    return empJoinDate;
  }
  /**
   * Gets the Employee Manager ID.
   * @return this Employee's Manager ID.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }
  /**
   * Gets the Employee Leave Bal.
   * @return this Employee's Leave Bal.
   */
  public final int getLeaveBal() {
    return empLeaveBal;
  }
  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   *
   * @param argEname to set employee name.
   */
  public final void setEname(final String argEname) {
    this.ename = argEname;
  }
  /**
   *
   * @param argPhone to set employee Phone.
   */
  public final void setPhone(final String argPhone) {
    this.empPhone = argPhone;
  }
  /**
   *
   * @param argEmail to set employee Email.
   */
  public final void setEmail(final String argEmail) {
    this.empEmail = argEmail;
  }
  /**
   *
   * @param argDept to set employee Dept.
   */
  public final void setDept(final String argDept) {
    this.empDept = argDept;
  }
  /**
   *
   * @param argDate to set employee Date of Join.
   */
  public final void setDate(final Date argDate) {
    this.empJoinDate = argDate;
  }
  /**
   *
   * @param argEmpMgrId to set employee Manager Id.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }
  /**
   *
   * @param argLeaveBal to set employee Leave Bal.
   */
  public final void setLeaveBal(final int argLeaveBal) {
    this.empLeaveBal = argLeaveBal;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
  /**
   * Update leaveBalance of employee.
   * @param empID id to enter employee details.
   * @param leaveTaken  to enter employee Leavetaken.
   * @return Status
   */

  public static String decrement(final int empID, final int leaveTaken) {
    dao().decrement(empID, leaveTaken);
    return "Leave Balance Updated";
  }
/**
   * Update employee LeaveBalance.
   * @param empID id to get employee id.
   * @param leaveDays to get employee leavenoofdays.
   * @return String.
   */
  public static String increment(final int empID, final int leaveDays) {
    dao().increment(empID, leaveDays);
    return "Leave Balance Updated";
  }
}
