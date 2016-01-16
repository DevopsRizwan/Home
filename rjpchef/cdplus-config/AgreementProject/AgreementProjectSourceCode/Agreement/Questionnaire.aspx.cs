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
    public partial class Questionnaire : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadQuestion();
            }
        }
        private void LoadQuestion()
        {
            QuestionnaireBI questionnaireBI = new QuestionnaireBI();
            List<QuestionnaireEntity> list = questionnaireBI.ReadList();
            gvQuestionnaire.DataSource = list;
            gvQuestionnaire.DataBind();
           
        }
        protected void btnSaveasDraft_Click(object sender, EventArgs e)
        {

        }

        protected void gvQuestionnaire_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void gvQuestionnaire_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
               
                Label lblAnswer = (Label)e.Row.FindControl("lblAnswer");
                TextBox txtAnswer = (TextBox)e.Row.FindControl("txtAnswer");
                RadioButtonList rdoAnswer = (RadioButtonList)e.Row.FindControl("rdoAnswer");
                if (lblAnswer.Text == "Y")
                {
                    txtAnswer.Visible = false;
                }
                else
                {
                    rdoAnswer.Visible = false;
                }
            }
        }
    }
}