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
using System.Configuration;
using System.IO;
using Agreement.WebHelper;

namespace Agreement.UserControls
{
    public partial class WorkControl : BaseControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                SetButtonVisibility();
                //  int agreementID = SessionManager.AgreementTypeID
                if (SessionManager.AgreementTypeID != 0)
                {
                    LoadWorkData(SessionManager.AgreementTypeID);
                }
                if (lblFileName.Text != string.Empty)
                {
                    valReqQuote.Enabled = false;
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
                btnClear.Visible = false;
                btnNext.Visible = false;
                btnSave.Visible = false;
                btnPrevious.Visible = false;
                tblContainer.Disabled = true;
            }
            if (SessionManager.AgreementType == "R")
            {
                secondrow.Visible = false;
                fourthRow.Visible = false;
                fifthRow.Visible = false;
                sixthRow.Visible = false;
            }
        }

        private void LoadWorkData(int agreementID)
        {
            WorkBI work = new WorkBI();
            WorkEntity entity = work.Read(agreementID);
            if (entity != null)
            {
                /*Assign Values to controls*/
                hdnWorkID.Value = Convert.ToString(entity.WorkID);
                rdoServicesProvided.SelectedValue = entity.ServicesProvided;
                rdoGovernmentMarketingServices.SelectedValue = entity.GovernmentMarketingServices;
                rdoLobbying.SelectedValue = entity.Lobbying;
                rdoNonEmpSalesRepresentation.SelectedValue = entity.NonEmpSalesRepresentation;

                txtServiceDescription.Text = entity.ServiceDescription;
                lblFileName.Text = entity.QuoteDocName;
                hdnFilePath.Value = entity.QuoteDocUniqueName;
            }
        }

        private int SaveData(string action)
        {
            WorkEntity entity = new WorkEntity();
            int agreementID = SessionManager.AgreementTypeID;
            entity.AgreementTypeID = agreementID;
            if (hdnWorkID.Value != string.Empty)
            {
                entity.WorkID = Convert.ToInt32(hdnWorkID.Value);

            }
            entity.ServicesProvided = rdoServicesProvided.SelectedValue;
            entity.GovernmentMarketingServices = rdoGovernmentMarketingServices.SelectedValue;
            entity.ServiceDescription = txtServiceDescription.Text.Trim();
            entity.Lobbying = rdoLobbying.SelectedValue;
            entity.NonEmpSalesRepresentation = rdoNonEmpSalesRepresentation.SelectedValue;

            bool isFileSaved = upload();
            //hdnWorkID.Value = Convert.ToString(entity.WorkID);

            string fileName = lblFileName.Text;
            string uniqueFileName = hdnFilePath.Value;
            entity.QuoteDocName = fileName;
            entity.QuoteDocUniqueName = uniqueFileName;

            //if (isFileSaved)
            //{
            if (SessionManager.AgreementType == "R" || fileName != string.Empty || action == "S")
            {
                WorkBI work = new WorkBI();
                int workID = work.Insert(entity);
                return workID;
            }

            //}
            return 0;
        }
        protected void btnSave_Click(object sender, EventArgs e)
        {

            int workID = SaveData("S");
            Status();
            if (workID != 0)
            {
                hdnWorkID.Value = workID.ToString();
                this.Page.ClientScript.RegisterStartupScript(Page.GetType(), "__SAVE__", "alert('Details saved.');", true);
            }
        }
        protected void ClearData()
        {
            //rdoServicesProvided.SelectedIndex = -1;
            rdoServicesProvided.ClearSelection();
            rdoGovernmentMarketingServices.ClearSelection();
            rdoLobbying.ClearSelection();
            rdoNonEmpSalesRepresentation.ClearSelection();
            txtServiceDescription.Text = string.Empty;
        }

        protected void btnClear_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID = 0;
            Response.Redirect("Home.aspx");
        }

        protected void btnNext_Click(object sender, EventArgs e)
        {
            int workID = SaveData("N");
            if (workID != 0)
            {
                hdnWorkID.Value = workID.ToString();
                Status();
                if (SessionManager.AgreementType == "R")
                    Response.Redirect("Approvers.aspx");
                else
                    Response.Redirect("Eligibility.aspx");
            }
        }
        private void Status()
        {
            Page.Validate("Next");
            WorkBI work = new WorkBI();
            work.InsertStatus((Page.IsValid ? 1 : 0), SessionManager.AgreementTypeID);

        }

        private bool upload()
        {
            string fileName = fuQuote.FileName;
            string uniqueFilename = Guid.NewGuid().ToString() + "_" + fileName;
            bool isfilesaved = false;
            if (fuQuote.HasFile)
            {
                string fileExtension = System.IO.Path.GetExtension(fuQuote.FileName).ToLower();
                if (fileExtension != ".txt" && fileExtension != ".doc")
                {
                    this.Page.ClientScript.RegisterStartupScript(Page.GetType(), "__save__", "alert('extension should  be .doc or .txt.');", true);
                }
                else
                {
                    int filesize = fuQuote.PostedFile.ContentLength;
                    int uploadKBLimit = Convert.ToInt32(ConfigurationManager.AppSettings["UploadKBLimit"]); //uploadkblimit is defined in web.config file
                    if ((filesize / 1024) > uploadKBLimit)
                    {
                        this.Page.ClientScript.RegisterStartupScript(Page.GetType(), "__save__", "alert('maximum file side should be " + uploadKBLimit.ToString() + "kb only.');", true);
                    }
                    else
                    {
                        fuQuote.SaveAs(Server.MapPath("App_Data\\QuoteDocs\\") + uniqueFilename);
                        lblFileName.Text = fileName;

                        /*deleting old file when user is uploaded a new file in edit mode.*/
                        if (hdnFilePath.Value != string.Empty)
                            File.Delete(Server.MapPath("App_Data\\QuoteDocs\\") + hdnFilePath.Value);

                        hdnFilePath.Value = uniqueFilename;
                        isfilesaved = true;
                    }
                }

            }

            return isfilesaved;

        }

        protected void lblFileName_Click(object sender, EventArgs e)
        {
            /*Download the file here*/
            string filePath = Server.MapPath("App_Data\\QuoteDocs\\") + hdnFilePath.Value;
            // The file path to download.
            string filename = Path.GetFileName(filePath);
            Response.ContentType = "application/octet-stream";
            Response.AppendHeader("Content-Disposition", "attachment;filename=" + filename);
            string aaa = Server.MapPath("App_Data\\QuoteDocs\\" + filename);
            Response.TransmitFile(Server.MapPath("App_Data\\QuoteDocs\\" + filename));
            Response.End();


        }

        protected void btnPrevious_Click(object sender, EventArgs e)
        {
            Response.Redirect("AgreementType.aspx");
        }

    }
}