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
using Agreement.WebHelper;
using Agreement.BusinessEntity;
using Agreement.BusinessLogic;

namespace Agreement
{
    public partial class Home : BasePage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                /*To remove browser cache*/
                Response.Cache.SetCacheability(HttpCacheability.NoCache);
            }
        }

        protected void gvApproval_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "E" || e.CommandName == "V")
            {
                string[] values = e.CommandArgument.ToString().Split(',');
                int agreementTypeID = Convert.ToInt32(values[0]);
                SessionManager.AgreementTypeID = agreementTypeID;
                int index = Convert.ToInt32(values[1]);
                SessionManager.ApprovalID = index;
                Response.Redirect("Approval.aspx");
            }
            if (e.CommandName == "T")
            {
                int index = Convert.ToInt32(e.CommandArgument);
                SessionManager.AgreementTypeID = index;
                Response.Redirect("ViewAgreement.aspx");
            }
        }

        protected void gvAgreementType_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void gvAgreementType_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "V")
            {
                string[] values = e.CommandArgument.ToString().Split(',');
                int agreementTypeID = Convert.ToInt32(values[0]);
                string status = values[1];
                // SessionManager.AgreementTypeID = Convert.ToInt32(gvAgreementType.Rows[Convert.ToInt32(e.CommandArgument)].Cells[1].Text); 
                SessionManager.AgreementTypeID = agreementTypeID;
                ////     string status = gvAgreementType.HeaderRow.Cells[4].Text;
                ////string status = gvAgreementType.Rows[index].Cells[4].Text;
                if (status == "Draft" || status == "Rejected")
                    Response.Redirect("AgreementType.aspx");
                else
                    Response.Redirect("ViewAgreement.aspx");

            }
            else if (e.CommandName == "D")
            {
                string[] values = e.CommandArgument.ToString().Split(',');
                int agreementTypeID = Convert.ToInt32(values[0]);
                string status = values[1];
                SessionManager.AgreementTypeID = agreementTypeID;
                if (status == "Draft")
                {
                    SessionManager.AgreementTypeID = agreementTypeID;
                    this.Page.ClientScript.RegisterStartupScript(Page.GetType(), "__Delete__", "alert('Are you sure, You wnat to Delete?');", true);
                    EligibilityBI eligibility = new EligibilityBI();
                    eligibility.DeleteMyAgreement(SessionManager.AgreementTypeID);
                    gvAgreementType.DataBind();
                }
            }
            else if (e.CommandName == "S")
            {
                string[] values = e.CommandArgument.ToString().Split(',');
                int agreementTypeID = Convert.ToInt32(values[0]);
                string status = values[1];
                SessionManager.AgreementTypeID = agreementTypeID;
                if (status == "Submitted" || status == "Approved" || status == "Rejected")
                {
                    SessionManager.AgreementTypeID = agreementTypeID;
                    Response.Redirect("Status.aspx");
                }
            }
        }

        protected void gvApproval_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType. DataRow)
            {
                Label lblStatus = (Label)e.Row.FindControl("lblStatus");
                string status = lblStatus.Text;

                if (status == "Draft")
                {
                    LinkButton lnkbtnView = (LinkButton)e.Row.FindControl("lnkbtnView");
                    DisableLink(lnkbtnView);
                    e.Row.BackColor = System.Drawing.Color.FromName("#FFFF99");
                    // e.Row.BackColor = System.Drawing.ColorTranslator.FromHtml("#F3F7AC"); 
                }
                if (status == "Approved")
                {
                    LinkButton lnkbtnEdit = (LinkButton)e.Row.FindControl("lnkbtnEdit");
                    lnkbtnEdit.Enabled = false;
                    lnkbtnEdit.ForeColor = System.Drawing.Color.Gray;
                    e.Row.BackColor = System.Drawing.Color.FromName("#99FF99");
                }

                if (status == "Rejected")
                {
                    LinkButton lnkbtnEdit = (LinkButton)e.Row.FindControl("lnkbtnEdit");
                    lnkbtnEdit.Enabled = false;
                    lnkbtnEdit.ForeColor = System.Drawing.Color.Gray;
                    e.Row.BackColor = System.Drawing.Color.FromName("#FF6A6A");
                }
            }
        }
        private void DisableLink(LinkButton lnkBtn)
        {
            lnkBtn.Enabled = false;
            lnkBtn.ForeColor = System.Drawing.Color.Gray;
        }

        protected void gvAgreementType_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                Label lblStatus = (Label)e.Row.FindControl("lblStatus");
                string status = lblStatus.Text;
                if (status != "Draft")
                {
                    LinkButton lnkDelete = (LinkButton)e.Row.FindControl("lnkDelete");
                    DisableLink(lnkDelete);
                }
                else
                {
                    LinkButton lnkStatus = (LinkButton)e.Row.FindControl("lnkStatus");
                    DisableLink(lnkStatus);
                }
            }
        }

    }
}