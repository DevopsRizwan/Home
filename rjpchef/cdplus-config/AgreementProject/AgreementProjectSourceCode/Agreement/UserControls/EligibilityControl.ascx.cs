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
using System.Drawing;

namespace Agreement.UserControls
{
    public partial class EligibilityControl : BaseControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (SessionManager.AgreementTypeID != 0)
                {
                    LoadEligibility(SessionManager.AgreementTypeID);
                }
                SetButtonVisibility();
            }

        }
       
        private void SetButtonVisibility()
        {
            if (Request.Url.AbsoluteUri.ToLower().Contains("viewagreement.aspx"))
            {
                gvEligibility.Columns[3].Visible = false;
                //Button btnAdd = (Button)gvEligibility.HeaderRow.FindControl("btnAdd");
                //btnAdd.Visible = false;
                Navigator1.Visible = false;
                btnPrevious.Visible = false;
                btnCancel.Visible = false;
                btnNext.Visible = false;
                tblContainer.Disabled = true;
                TextBox txtFirstName = (TextBox)gvEligibility.HeaderRow.FindControl("txtFirstName");
                txtFirstName.Visible = false;
                TextBox txtLastName = (TextBox)gvEligibility.HeaderRow.FindControl("txtLastName");
                txtLastName.Visible = false;
                TextBox txtSSN = (TextBox)gvEligibility.HeaderRow.FindControl("txtSSN");
                txtSSN.Visible = false;
            }
            if (SessionManager.AgreementType == "R")
            {
               // gvEligibility.Visible = false;
                tblContainer.Visible = false;
            }
        }


        private void LoadEligibility(int ID)
        {
            EligibilityBI eligibility = new EligibilityBI();
            List<EligibilityEntity> list = eligibility.ReadList(ID);

            /*Returns the list records received from the DB.*/
            hdnGridRecords.Text = list.Count.ToString();

            ///*if there is no data in database table then we are creating a dummy record to disply the grid.*/
            if (list.Count == 0)
            {
                list.Add(new EligibilityEntity() { EligibilityID = 0, FirstName = "", LastName = "", SSN = "" });
            }
            gvEligibility.DataSource = list;
            gvEligibility.DataBind();
            AddValidationControls();
        }

        protected void AddValidationControls()
        {
            RequiredFieldValidator valdReqFirstName = new RequiredFieldValidator();
            TextBox txtFirstName = (TextBox)gvEligibility.HeaderRow.FindControl("txtFirstName");
            valdReqFirstName.ControlToValidate = txtFirstName.ID;
            valdReqFirstName.ErrorMessage = "<br/>Please Enter First Name.";
            valdReqFirstName.ValidationGroup = "Add";
            valdReqFirstName.ForeColor = System.Drawing.Color.Red;
            valdReqFirstName.Display = ValidatorDisplay.Dynamic;
            gvEligibility.HeaderRow.Cells[0].Controls.Add(valdReqFirstName);

            RequiredFieldValidator valdReqLastName = new RequiredFieldValidator();
            TextBox txtLastName = (TextBox)gvEligibility.HeaderRow.FindControl("txtLastName");
            valdReqLastName.ControlToValidate = txtLastName.ID;
            valdReqLastName.ErrorMessage = "<br/>Please Enter Last Name.";
            valdReqLastName.ForeColor = System.Drawing.Color.Red;
            valdReqLastName.ValidationGroup = "Add";
            valdReqLastName.Display = ValidatorDisplay.Dynamic;
            gvEligibility.HeaderRow.Cells[1].Controls.Add(valdReqLastName);


            RequiredFieldValidator valdReqSSN = new RequiredFieldValidator();
            TextBox txtSSN = (TextBox)gvEligibility.HeaderRow.FindControl("txtSSN");
            RegularExpressionValidator valregexSSN = new RegularExpressionValidator();
            valregexSSN.ControlToValidate = txtSSN.ID;
            valregexSSN.ValidationExpression = "\\d{4}";
            valregexSSN.ForeColor = System.Drawing.Color.Red;
            valregexSSN.ErrorMessage = "Please Enter Last Four Digits Only.";
            valregexSSN.SetFocusOnError = true;
            valregexSSN.ValidationGroup = "Add";
            valregexSSN.Display = ValidatorDisplay.Dynamic;
            gvEligibility.HeaderRow.Cells[2].Controls.Add(valregexSSN);
            //txtSSN.
            valdReqSSN.ControlToValidate = txtSSN.ID;
            valdReqSSN.SetFocusOnError = true;
            valdReqSSN.ForeColor = System.Drawing.Color.Red;
            valdReqSSN.ErrorMessage = "<br/>Please Enter SSN.";
            valdReqSSN.ValidationGroup = "Add";
            valdReqSSN.Display = ValidatorDisplay.Dynamic;
            gvEligibility.HeaderRow.Cells[2].Controls.Add(valdReqSSN);
        }

        protected void gvEligibility_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            /*this will hide the dummy row*/
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                Label lblEligibilityID = (Label)e.Row.FindControl("lblEligibilityID");
                if (lblEligibilityID.Text == "0")
                {
                    e.Row.Visible = false;
                }
            }
        }

        protected void gvEligibility_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        private int SaveData()
        {

            TextBox txtFirstName = (TextBox)gvEligibility.HeaderRow.FindControl("txtFirstName");
            TextBox txtLastName = (TextBox)gvEligibility.HeaderRow.FindControl("txtLastName");
            TextBox txtSSN = (TextBox)gvEligibility.HeaderRow.FindControl("txtSSN");
            //AddValidation();
            EligibilityEntity entity = new EligibilityEntity();
            int agreementID = SessionManager.AgreementTypeID;
            entity.AgreementTypeID = agreementID;
            if (hdnEligibilityID.Value != string.Empty)
            {
                entity.EligibilityID = Convert.ToInt32(hdnEligibilityID.Value);
            }
            entity.FirstName = txtFirstName.Text.Trim();
            entity.LastName = txtLastName.Text.Trim();
            entity.SSN = txtSSN.Text.Trim();
            //AddValidationControls();
            EligibilityBI eligibility = new EligibilityBI();

            int eligibilityID = eligibility.Insert(entity);
            return eligibilityID;
        }

        protected void gvEligibility_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "A")
            {
                SaveData();
                LoadEligibility(SessionManager.AgreementTypeID);
                hdnEligibilityID.Value = string.Empty;

            }
            else if (e.CommandName == "E")
            {
                int eligibilityID = e.CommandArgument.ToInt32();
                DisplayEligibility(eligibilityID);
                Button btnAdd = (Button)gvEligibility.HeaderRow.FindControl("btnAdd");
                btnAdd.Text = "Update";
                AddValidationControls();
            }
            else if (e.CommandName == "D")
            {
               // this.Page.ScriptManager.RegisterStartupScript(Page, Page.GetType, "__Delete__", "alert('Are you sure, You wnat to Delete?');", true);
                
                EligibilityBI eligibility = new EligibilityBI();
                eligibility.Delete(Convert.ToInt32(e.CommandArgument));
                LoadEligibility(SessionManager.AgreementTypeID);
            }
        }

        private void DisplayEligibility(int ID)
        {
            EligibilityBI eligibility = new EligibilityBI();
            EligibilityEntity entity = eligibility.Read(ID);

            TextBox txtFirstName = (TextBox)gvEligibility.HeaderRow.FindControl("txtFirstName");
            TextBox txtLastName = (TextBox)gvEligibility.HeaderRow.FindControl("txtLastName");
            TextBox txtSSN = (TextBox)gvEligibility.HeaderRow.FindControl("txtSSN");
            hdnEligibilityID.Value = Convert.ToString(entity.EligibilityID);

            txtFirstName.Text = entity.FirstName;
            txtLastName.Text = entity.LastName;
            txtSSN.Text = entity.SSN;
        }

        protected void btnPrevious_Click(object sender, EventArgs e)
        {
            Response.Redirect("Work.aspx");
        }

        protected void btnNext_Click(object sender, EventArgs e)
        {
            //  SaveData();
            Page.Validate("Next");
            if (Page.IsValid)
            {
                int eligibilityStatus = 1;

                EligibilityBI eligibilityBI = new EligibilityBI();
                eligibilityBI.InsertStatus(eligibilityStatus, SessionManager.AgreementTypeID);
            }
            Response.Redirect("Approvers.aspx");
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID=0;
            Response.Redirect("Home.aspx");
        }


    }

}