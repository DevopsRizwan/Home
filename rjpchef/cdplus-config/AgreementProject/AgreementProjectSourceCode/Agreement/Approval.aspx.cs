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
using System.Net.Mail;
using System.IO;

namespace Agreement
{
    public partial class Approval : BasePage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (SessionManager.ApprovalID != 0)
                    DataDisplay(Convert.ToInt32(SessionManager.AgreementTypeID));

            }
        }
        private void DataDisplay(int agreementTypeID)
        {
            ApprovalBI approval = new ApprovalBI();
            ApprovalEntity entity = approval.Read(agreementTypeID,SessionManager.ApprovalID);
            if (entity != null)
            {
                /*Assign Values to controls*/
                lblAgreementNo.Text = Convert.ToString(agreementTypeID);
                lblAgreementTitle.Text = entity.Title;
                if (entity.Status != "D")
                {
                    txtAction.Text = entity.Actions;
                    txtComment.Text = entity.Comments;
                    btnApprove.Visible = false;
                    btnReject.Visible = false;
                }
            }


        }
        protected void btnApprove_Click(object sender, EventArgs e)
        {
            ApprovalEntity entity = new ApprovalEntity();
            int approvalID = Convert.ToInt32(SessionManager.ApprovalID);
            entity.ApprovalID = (approvalID);
            entity.AgreementTypeID = SessionManager.AgreementTypeID;
            entity.Comments = txtComment.Text.Trim();
            entity.Actions = txtAction.Text.Trim();
            entity.Status = "A";

            ApprovalBI approver = new ApprovalBI();
            approver.Insert(entity);

            ClientScript.RegisterStartupScript( Page.GetType(), "_Approved_", "alert('Agreement Approved');window.location='home.aspx';", true);
            
           
            //ClearData();

            //btnApprove.Visible = false;
            //btnReject.Visible = false;
            //btnCancel.Text = "Go TO Home";

        }
        protected void btnReject_Click(object sender, EventArgs e)
        {
            ApprovalEntity entity = new ApprovalEntity();

            entity.AgreementTypeID = SessionManager.AgreementTypeID;
            entity.ApprovalID = SessionManager.ApprovalID;
            entity.Comments = txtComment.Text.Trim();
            entity.Actions = txtAction.Text.Trim();
            entity.Status = "R";

            ApprovalBI approver = new ApprovalBI();
            approver.Insert(entity);


            /*#TODO:Get user's email id based on the agreement id.*/
            AgreementTypeBI agreementTypeBI = new AgreementTypeBI();
            AgreementTypeEntity agreemententity = agreementTypeBI.ReadTitle(SessionManager.AgreementTypeID);
              
            string email = agreemententity.Email;
            string agreementTitle = agreemententity.Title;


            string approverName = SessionManager.UsersEntity.FullName;
            string body = null;

            //body = 
            using (StreamReader sr = new StreamReader(Server.MapPath("Templates\\EmailTemplete.txt")))
            {
                body = sr.ReadToEnd();
            }

            body = body.Replace("[APPROVER_NAME]", approverName);
            body = body.Replace("[AGREEMENT_TITLE]", agreementTitle);
            body = body.Replace("[APPROVER_NAME]", approverName);
            body = body.Replace("[COMMENTS]", txtComment.Text.Trim());
            body = body.Replace("[ACTIONS]", txtAction.Text.Trim());

            EmailHelper.SendEmail(new List<string>() { email }, agreementTitle + " Agreement Rejected", body, null);

            ClientScript.RegisterStartupScript(Page.GetType(), "_Rejected_", "alert('Agreement Rejected');window.location='home.aspx';", true);
            //ClearData();

            //btnApprove.Visible = false;
            //btnReject.Visible = false;
            //btnCancel.Text = "Go To Home";
        }

        private void ClearData()
        {
            txtAction.Text = string.Empty;
            txtComment.Text = string.Empty;
            lblAgreementNo.Text = string.Empty;
        }
        protected void btnCancel_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID=0;
            SessionManager.ApprovalID = 0;
            Response.Redirect("Home.aspx");
        }
    }
}