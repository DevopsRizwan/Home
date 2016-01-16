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
using Agreement.WebHelper;
using Agreement.BusinessLogic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace Agreement.UserControls
{
    public partial class AgreementTypeControl : BaseControl
    {

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // ddlRegisteredVendor.SelectedIndex = -1;
                panelRegisteredVendor.Visible = false;
                panelAnonymousVendor.Visible = false;
                SetButtonVisibility();
                //BindBusinessType();
                if (SessionManager.AgreementTypeID != 0)
                {
                    //if(rdoAgreementType.SelectedValue == "R")
                    //    panelRegisteredVendor.Visible = true;
                    //else 
                    //   panelAnonymousVendor.Visible = true;
                    LoadAgreementType(SessionManager.AgreementTypeID);
                }
            }
        }

        private void SetButtonVisibility()
        {
            if (Request.Url.AbsoluteUri.ToLower().Contains("viewagreement.aspx"))
            {
                btnCancel.Visible = false;
                btnNext.Visible = false;
                btnSave.Visible = false;
                panelVendors.Enabled = false;
                Navigator1.Visible = false;

            }
            if (SessionManager.AgreementType == "R")
            {
                panelRegisteredVendor.Enabled = false;
            }
        }

        private void LoadAgreementType(int agreementId)
        {
            AgreementTypeBI agreementType = new AgreementTypeBI();
            AgreementTypeEntity entity = agreementType.Read(agreementId);
            if (entity != null)
            {
                /*Assign Values to controls*/
                if (entity.AgreementType == "A")
                {
                    BindBusinessType();
                    panelAnonymousVendor.Visible = true;
                    rdoAgreementType.SelectedValue = entity.AgreementType;
                    rdoWorkType.SelectedValue = entity.WorkType;
                    txtTitle.Text = entity.Title;
                    //  ddlBusinessType.SelectedValue = entity.BusinessType;
                    ddlBusinessType.SelectedIndex = (entity.BusinessTypeID);
                }
                else
                {
                    /* to disable eligibility link */
                    LinkButton lnkEligibility = (LinkButton)Navigator1.FindControl("lnkEligibility");
                    lnkEligibility.Visible = false;
                    // bind register venders 
                    BindRegisteredVendor();
                    panelRegisteredVendor.Visible = true;
                    SessionManager.AgreementType = "R";
                    rdoAgreementType.SelectedValue = entity.AgreementType;
                    ddlRegisteredVendor.SelectedIndex = entity.VendorID;
                    txtTitleRegistered.Text = entity.Title;
                    txtTaxIdentification.Text = entity.USTaxIdentificationNo;
                    txtUNIQUE.Text = entity.UNIQUENo;
                    rdotechnical.SelectedValue = entity.TechnicalInformation;
                    ddlRegisteredVendor_SelectedIndexChanged(null, null);
                }
            }
        }

        private void ClearData()
        {
            rdoAgreementType.ClearSelection();
            rdoWorkType.ClearSelection();
            txtTitle.Text = string.Empty;
            ddlBusinessType.SelectedValue = string.Empty;
        }



        private void BindBusinessType()
        {

            AgreementTypeBI agreementType = new AgreementTypeBI();
            List<AgreementTypeEntity> list = agreementType.ReadList();
            ddlBusinessType.DataSource = list;
            ddlBusinessType.DataValueField = "BusinessTypeID";
            ddlBusinessType.DataTextField = "BusinessType";
            ddlBusinessType.DataBind();
            Application["BusinessType"] = list;
            ListItem item = new ListItem("--Select--", "");
            ddlBusinessType.Items.Insert(0, item);


        }

        protected void btnSave_Click(object sender, EventArgs e)
        {

            int agreementTypeID = SaveData();
            SessionManager.AgreementTypeID = agreementTypeID;
            Status();
            // ScriptManager.RegisterStartupScript(Page.GetType(), "__SAVE__", "alert('Details saved.');", true);
            ScriptManager.RegisterStartupScript(this.Page, Page.GetType(), "__SAVE__", "alert('Details saved.');", true);

            /*Below code is for AJAX*/
            //ScriptManager.RegisterClientScriptBlock(

            // LoadAgreementType(Convert.ToInt32(hdnAgreementID.Value));
            // ClearData();

        }
        protected void btnNext_Click(object sender, EventArgs e)
        {

            int agreementTypeID = SaveData();
            SessionManager.AgreementTypeID = agreementTypeID;
            Status();
            Response.Redirect("Work.aspx");
        }
        private void Status()
        {
            Page.Validate("Next");
            int agreementTypeStatus = 0;
            if (Page.IsValid)
            {
                agreementTypeStatus = 1;

            }
            else
            {
                agreementTypeStatus = 0;

            }
            AgreementTypeBI agreementTypeBI = new AgreementTypeBI();
            agreementTypeBI.InsertStatus(agreementTypeStatus, SessionManager.AgreementTypeID);
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            //ClearData();
            SessionManager.AgreementTypeID = 0;
            Response.Redirect("Home.aspx");

        }
        private int SaveData()
        {
            AgreementTypeEntity entity = new AgreementTypeEntity();
            if (SessionManager.AgreementTypeID != 0)
                entity.AgreementTypeID = SessionManager.AgreementTypeID;
            entity.UserID = SessionManager.UsersID;

            entity.AgreementType = rdoAgreementType.SelectedValue;
            if (rdoAgreementType.SelectedValue == "A")
            {
                entity.WorkType = rdoWorkType.SelectedValue;
                entity.Title = txtTitle.Text;
                entity.BusinessTypeID = Convert.ToInt32(ddlBusinessType.SelectedValue);
            }
            else
            {
                entity.VendorID = ddlRegisteredVendor.SelectedIndex;
                entity.Title = txtTitleRegistered.Text;
                entity.USTaxIdentificationNo = txtTaxIdentification.Text;
                entity.UNIQUENo = txtUNIQUE.Text;
                entity.TechnicalInformation = rdotechnical.SelectedValue;
            }
            AgreementTypeBI agreementType = new AgreementTypeBI();

            int agreementTypeID = agreementType.Insert(entity);
            return agreementTypeID;
        }

        protected void rdoAgreementType_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (rdoAgreementType.SelectedValue == "R")
            {
                SessionManager.AgreementType = "R";
                LinkButton lnkEligibility = (LinkButton)Navigator1.FindControl("lnkEligibility");
                lnkEligibility.Visible = false;
                panelRegisteredVendor.Visible = true;
                panelAnonymousVendor.Visible = false;
                BindRegisteredVendor();
            }
            else
            {
                SessionManager.AgreementType = "A";
                panelRegisteredVendor.Visible = false;
                panelAnonymousVendor.Visible = true;
                BindBusinessType();
            }
        }
        private void BindRegisteredVendor()
        {
            VendorServices.Vendors vendor = new VendorServices.Vendors();
            DataSet ds = vendor.GetVendorList();
            ddlRegisteredVendor.DataSource = ds;
            ddlRegisteredVendor.DataValueField = "VendorID";
            ddlRegisteredVendor.DataTextField = "Name";
            ddlRegisteredVendor.DataBind();
            ListItem item = new ListItem("--Select--", "");
            ddlRegisteredVendor.Items.Insert(0, item);
        }

        protected void ddlRegisteredVendor_SelectedIndexChanged(object sender, EventArgs e)
        {
            int vendorID = ddlRegisteredVendor.SelectedIndex;
            VendorServices.Vendors vendor = new VendorServices.Vendors();
            DataSet ds = vendor.GetVendorByID(vendorID);
            lblStreetAdress.Text = ds.Tables[0].Rows[0][2].ToStr();
            lblCity.Text = ds.Tables[0].Rows[0][3].ToStr();
            lblState.Text = ds.Tables[0].Rows[0][4].ToStr();
            lblZip.Text = ds.Tables[0].Rows[0][5].ToStr();
            lblCountry.Text = ds.Tables[0].Rows[0][6].ToStr();
            lblPhoneNumber.Text = ds.Tables[0].Rows[0][7].ToStr();
            lblFaxNumber.Text = ds.Tables[0].Rows[0][8].ToStr();
            lblContactName.Text = ds.Tables[0].Rows[0][9].ToStr();
            lblContactEmail.Text = ds.Tables[0].Rows[0][10].ToStr();
            // ViewState["VendorID"] = ds.Tables[0].Rows[0][0].ToStr();
            // textbox1.text = Dataset.Tables[0].Rows[0][0].ToString();


        }
    }
}