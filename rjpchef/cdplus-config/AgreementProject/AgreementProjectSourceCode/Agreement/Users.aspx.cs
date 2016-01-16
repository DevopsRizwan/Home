/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Agreement.BusinessEntity;
using Agreement.BusinessLogic;
using Agreement.WebHelper;
namespace Agreement
{
    public partial class Users :BasePage 
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                if (SessionManager.UsersEntity.UserType != "E")
                {
                    Response.Redirect("loginpage.aspx?msg=You are not authorized to view this page.", true);
                    return;
                }
                LoadUsers();
            }
        }
        private void LoadUsers()  //load all the data to gridview
        {
            UsersBI users = new UsersBI();
            List<UsersEntity> list = users.ReadList();

            dtgUsers.DataSource = list;
            dtgUsers.DataBind();//to bind datasource to Gridview control

        }

        private void ClearData() //clean data from each field
        {
            txtFirstName.Text = string.Empty;
            txtLastName.Text = string.Empty;
            txtPhoneNumber.Text = string.Empty;
            txtEmail.Text = string.Empty;
            txtEmpID.Text = string.Empty;
            txtUserName.Text = string.Empty;
            txtPassword.Text = string.Empty;
            txtConfirmPassword.Text = string.Empty;
            ddlUseType.SelectedValue = string.Empty;
            hdnUserID.Value = string.Empty;
            // enable required field validators
            valReqConfirmPassword.Enabled = true;
            valReqPassword.Enabled = true;
            valComparePassword.Enabled = true;

        }

        protected void dtgUsers_RowCommand(object sender, GridViewCommandEventArgs e) //Occurs when a button is clicked in a GridView control.
        {
            if (e.CommandName == "E")
            {
                DisplayUser(Convert.ToInt32(e.CommandArgument));//Convert the row index stored in the CommandArgument property to an Integer and call the function displayusers.
                // disable validators
                valReqConfirmPassword.Enabled = false;
                valReqPassword.Enabled = false;
                valComparePassword.Enabled = false;
            }
            else if (e.CommandName == "D")
            {

                UsersBI users = new UsersBI();
                users.Delete(Convert.ToInt32(e.CommandArgument));
                LoadUsers();
            }
        }
        private void DisplayUser(int UserID)  //display data from gridview to relevant controls
        {
            UsersBI users = new UsersBI();
            UsersEntity entity = users.Read(UserID);
            hdnUserID.Value = UserID.ToString();
            //select the records and display it on the screen
            txtFirstName.Text = entity.FirstName;
            txtLastName.Text = entity.LastName;
            txtPhoneNumber.Text = entity.PhoneNo;
            txtEmail.Text = entity.Email;
            txtEmpID.Text = entity.EmpID;
            //if (hdnUserID.Value == string.Empty)
            //{
                txtUserName.Text = entity.UserName;
                txtPassword.Text = entity.Password;
            //}
            //else
            //{
            //    idPassword.Disabled = true;
            //    idConfirmPassword.Disabled = true;
                
            //}
            ddlUseType.SelectedValue = entity.UserType;

        }

        protected void btnSave_Click(object sender, EventArgs e) // Insert data to database and load that data to gridview
        {
            try
            {
                //Customersql obj = new Customersql();
                
                UsersEntity entity = new UsersEntity();
                if (hdnUserID.Value != string.Empty)
                     entity.UserID = Convert.ToInt32(hdnUserID.Value);
                entity.FirstName = txtFirstName.Text;
                entity.LastName = txtLastName.Text;
                entity.PhoneNo = txtPhoneNumber.Text;
                entity.Email = txtEmail.Text;
                entity.EmpID = txtEmpID.Text;
                entity.UserName = txtUserName.Text;
                entity.Password = txtPassword.Text;
                entity.UserType = ddlUseType.SelectedValue;


                UsersBI users = new UsersBI();
                //if (hdnUserID.Value == string.Empty)
                //{
                users.Insert(entity);
                //}
                //else
                //{
                //    users.Update(entity);
                //}
                LoadUsers();
                ClearData();
            }
            catch (Exception ex)
            {
                Response.Write(ex.Message.ToString());
            }
        }

        protected void btnClear_Click(object sender, EventArgs e) // clear all controls data
        {
            ClearData();
        }

        protected void dtgUsers_RowDataBound(object sender, GridViewRowEventArgs e) //Occurs when a data row is bound to data in a GridView control
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {

                Label lblUserTypeGv = (Label)e.Row.FindControl("lblUserType");
                if (lblUserTypeGv.Text == "E")
                {
                    lblUserTypeGv.Text = "Examiner";
                }
                else if (lblUserTypeGv.Text == "U")
                {
                    lblUserTypeGv.Text = "User";
                   // lblUserTypeGv.ForeColor = System.Drawing.Color.Red;
                  //  lblUserTypeGv.Visible = false;
                }
                else if (lblUserTypeGv.Text == "A")
                {
                    lblUserTypeGv.Text = "Approver";
                }
            }
        }
        /* This event is for display gridview data*/
        protected void dtgUsers_PageIndexChanging(object sender, GridViewPageEventArgs e) 
        {
            dtgUsers.PageIndex = e.NewPageIndex;
            LoadUsers();
         }

        protected void dtgUsers_Sorting(object sender, GridViewSortEventArgs e)
        {
           
        }
    }
}