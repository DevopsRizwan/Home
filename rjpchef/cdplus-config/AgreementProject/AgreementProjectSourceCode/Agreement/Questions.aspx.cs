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
    public partial class Questions : System.Web.UI.Page
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
                LoadQuestion();
            }

        }
        private void LoadQuestion()
        {
            QuestionsBI questionBI = new QuestionsBI();
            List<QuestionsEntity> list = questionBI.ReadList();
            gvQuestions.DataSource = list;
            gvQuestions.DataBind();

        
        }
        protected void btnSave_Click(object sender, EventArgs e)
        {
            SaveQuestion();
            Clear();
            LoadQuestion();
        }
        private void Clear()
        {
            txtQuestion.Text = string.Empty;
            SessionManager.QuestionID = 0;
            txtSrNo.Text = string.Empty;
            rdoAnswerType.SelectedIndex = -1;
        }
        private void SaveQuestion()
        {
            QuestionsEntity entity = new QuestionsEntity();
            if (SessionManager.QuestionID != null)
            {
                entity.QuestionID = SessionManager.QuestionID;
            }
            entity.Sno = Convert.ToInt32(txtSrNo.Text);
            entity.Question = txtQuestion.Text;
            entity.AnswerType = rdoAnswerType.SelectedValue;

            QuestionsBI questionsBI = new QuestionsBI();
            questionsBI.InsertQuestion(entity);


            //txtSrNo.Text = entity.Sno;
            //txtQuestion = entity.Question;
            //rdoAnswerType.SelectedValue = entity.
            
        }
        private void DiaplayQuestion(int questionID)
        {
            QuestionsBI questionBI = new QuestionsBI();
            QuestionsEntity entity = questionBI.Read(questionID);
            txtSrNo.Text = Convert.ToString(entity.Sno);
            txtQuestion.Text = entity.Question;
            rdoAnswerType.SelectedValue = entity.AnswerType;

        }

        protected void gvQuestions_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "E")
            {
                SessionManager.QuestionID = Convert.ToInt32(e.CommandArgument);
                DiaplayQuestion(SessionManager.QuestionID);
            }

            if (e.CommandName == "D")
            {
                SessionManager.QuestionID = Convert.ToInt32(e.CommandArgument);
                QuestionsBI questionBI = new QuestionsBI();
                questionBI.Delete(SessionManager.QuestionID);
                LoadQuestion();
            }
        }

        protected void gvQuestions_Sorting(object sender, GridViewSortEventArgs e)
        {

        }

    }
}