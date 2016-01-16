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
using Agreement.WebHelper;
namespace Agreement
{
    public partial class Status : BasePage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if(SessionManager.AgreementTypeID != 0 )
                LoadStatus(SessionManager.AgreementTypeID);
            }
        }

        private void LoadStatus(int agreementID)  //load all the data to gridview
        {
            StatusBI status = new StatusBI();
            List<StatusEntity> list = status.ReadList(agreementID);

            gvStatus.DataSource = list;
            gvStatus.DataBind();
           
        }

        protected void gvStatus_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {

                Label lblStatus = (Label)e.Row.FindControl("lblStatus");
                string status = lblStatus.Text;

                if (status == "Pending")
                {
                    e.Row.BackColor = System.Drawing.Color.FromName("#FFFF99");
                    // e.Row.BackColor = System.Drawing.ColorTranslator.FromHtml("#F3F7AC"); 
                }
                else if (status == "Approved" || status == "Sumbmitted")
                {
                    e.Row.BackColor = System.Drawing.Color.FromName("#99FF99");

                }

                else if (status == "Rejected")
                {

                    e.Row.BackColor = System.Drawing.Color.FromName("#FF6A6A");
                }
                Label lblActionDate = (Label)e.Row.FindControl("lblActionDate");
                if (lblActionDate.Text == Convert.ToString(DateTime.MinValue))
                {
                    lblActionDate.Text = string.Empty;
                }
            }
        }

        protected void btnHome_Click(object sender, EventArgs e)
        {
            SessionManager.AgreementTypeID = 0;
            Response.Redirect("home.aspx");
        }
    }
}