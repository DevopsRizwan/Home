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

namespace Agreement.UserControls
{
    public partial class ApproverControl : BaseControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                SetButtonVisibility();
                BindApprovers();
                if (SessionManager.AgreementTypeID != 0)
                {
                    LoadApprovers(SessionManager.AgreementTypeID);
                }
                if (SessionManager.AgreementType == "R")
                {
                    LinkButton lnkEligibility = (LinkButton)Navigator1.FindControl("lnkEligibility");
                    lnkEligibility.Visible = false;
                }
            }
        }

        private void SetButtonVisibility()
        {
            if (Request.Url.AbsoluteUri.ToLower().Contains("viewagreement.aspx"))
            {
                Navigator1.Visible = false;
                btnSave.Visible = false;
                btnPrevious.Visible = false;
                btnCancel.Visible = false;
                btnNext.Visible = false;
                tblContainer.Disabled = true;
            }
        }
        private void BindApprovers()
        {
            List<UsersEntity> list = new UsersBI().GetApproverList();

            BindDropDown(list, ddlAgreementReviewer);
            BindDropDown(list, ddlBusinessTypeApprover);
            BindDropDown(list, ddlLawyerApprover);
            BindDropDown(list, ddlOtherApprover);

        }

        private void BindDropDown(List<UsersEntity> list, DropDownList dropDownList)
        {
            dropDownList.DataSource = list;
            dropDownList.DataValueField = "UserID";
            dropDownList.DataTextField = "FullName";
            dropDownList.DataBind();
            dropDownList.Items.Insert(0, new ListItem("Select", ""));
            //dropDownList.Items.Insert(dropDownList.Items.Count , new ListItem("smile", ""));
        }
        private void LoadApprovers(int ID)
        {
            ApproverBI approver = new ApproverBI();
            ApproversEntity entity = approver.Read(ID);
            if (entity != null)
            {
                /*Assign Values to controls*/
                hdnAgreementApproversID.Value = Convert.ToString(entity.AgreementApproversID);

                SetApproverValue(ddlAgreementReviewer, entity.AgreementReviewer);
                SetApproverValue(ddlBusinessTypeApprover, entity.BusinessReviewer);
                SetApproverValue(ddlLawyerApprover, entity.LawyerApprover);
                SetApproverValue(ddlOtherApprover, entity.OtherApprover);
            }
        }

        private void SetApproverValue(DropDownList ddl, int? approverID)
        {
            if (approverID == null)
                ddl.SelectedValue = string.Empty;
            else
                ddl.SelectedValue = Convert.ToString(approverID);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {

            int agreementApproverID = SaveData();
            hdnAgreementApproversID.Value = Convert.ToString(agreementApproverID);
        }
        private void Status()
        {
            Page.Validate("Next");
            if (Page.IsValid)
            {
                int approversStatus = 1;
                ApproverBI approverBI = new ApproverBI();
                approverBI.InsertStatus(approversStatus, SessionManager.AgreementTypeID);
            }
            else
            {
                int approversStatus = 0;
                ApproverBI approverBI = new ApproverBI();
                approverBI.InsertStatus(approversStatus, SessionManager.AgreementTypeID);
            }
        }
        protected void btnNext_Click(object sender, EventArgs e)
        {
            int agreementApproverID = SaveData();
            hdnAgreementApproversID.Value = Convert.ToString(agreementApproverID);

            Status();
            Response.Redirect("Submit.aspx");

        }

        private int SaveData()
        {
            ApproversEntity entity = new ApproversEntity();
            // int agreementID = SessionManager.AgreementTypeID
            int agreementID = SessionManager.AgreementTypeID;
            entity.AgreementTypeID = agreementID;

            if (hdnAgreementApproversID.Value != string.Empty)
            {
                entity.AgreementApproversID = Convert.ToInt32(hdnAgreementApproversID.Value);
            }

            if (ddlAgreementReviewer.SelectedValue == string.Empty)
                entity.AgreementReviewer = null;
            else
                entity.AgreementReviewer = Convert.ToInt32(ddlAgreementReviewer.SelectedValue);

            if (ddlBusinessTypeApprover.SelectedValue == string.Empty)

                entity.BusinessReviewer = null;
            else
                //entity.BusinessReviewer = Convert.ToInt32(ddlBusinessTypeApprover.SelectedIndex);
                entity.BusinessReviewer = Convert.ToInt32(ddlBusinessTypeApprover.SelectedValue);

            if (ddlLawyerApprover.SelectedValue == string.Empty)

                entity.LawyerApprover = null;
            else
                //entity.LawyerApprover = Convert.ToInt32(ddlBusinessTypeApprover.SelectedValue);
                entity.LawyerApprover = Convert.ToInt32(ddlLawyerApprover.SelectedValue);
            if (ddlOtherApprover.SelectedValue == string.Empty)

                entity.OtherApprover = null;
            else
                //entity.OtherApprover = Convert.ToInt32(ddlBusinessTypeApprover.SelectedValue);
                entity.OtherApprover = Convert.ToInt32(ddlOtherApprover.SelectedValue);

            ApproverBI approver = new ApproverBI();
            int agreementApproverID = approver.Insert(entity);
            Status();
            return agreementApproverID;
        }

        protected void btnPrevious_Click(object sender, EventArgs e)
        {
            if (SessionManager.AgreementType == "R")
                Response.Redirect("Work.aspx");
            else
                Response.Redirect("Eligibility.aspx");
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID = 0;
            Response.Redirect("Home.aspx");
        }
        private void ClearData()
        {
            ddlAgreementReviewer.SelectedValue = string.Empty;
            ddlBusinessTypeApprover.SelectedValue = string.Empty;
            ddlLawyerApprover.SelectedValue = string.Empty;
            ddlOtherApprover.SelectedValue = string.Empty;
        }
    }
}