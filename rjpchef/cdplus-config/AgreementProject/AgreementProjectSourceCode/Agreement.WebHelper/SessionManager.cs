/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;
using Agreement.BusinessEntity;

namespace Agreement.WebHelper
{
    public class SessionManager
    {
        public static int AgreementTypeID
        {
            get
            {
                if (HttpContext.Current.Session["AgreementTypeID"] == null)
                    return 0;
                else
                    return Convert.ToInt32(HttpContext.Current.Session["AgreementTypeID"]);
            }
            set
            {
                if (value == 0)
                    HttpContext.Current.Session["AgreementTypeID"] = null;
                else
                    HttpContext.Current.Session["AgreementTypeID"] = value;
            }
        }
        public static int QuestionID
        {
            get
            {
                if (HttpContext.Current.Session["QuestionID"] == null)
                    return 0;
                else
                    return Convert.ToInt32(HttpContext.Current.Session["QuestionID"]);
            }
            set
            {
                if (value == 0)
                    HttpContext.Current.Session["QuestionID"] = null;
                else
                    HttpContext.Current.Session["QuestionID"] = value;
            }
        }

        public static int UsersID
        {
            get
            {
                if (HttpContext.Current.Session["UsersID"] == null)
                    return 0;
                else
                    return Convert.ToInt32(HttpContext.Current.Session["UsersID"]);
            }
            set
            {
                if (value == 0)
                    HttpContext.Current.Session["UsersID"] = null;
                else
                    HttpContext.Current.Session["UsersID"] = value;
            }
        }

        public static int ApprovalID
        {
            get
            {
                if (HttpContext.Current.Session["ApprovalID"] == null)
                    return 0;
                else
                    return Convert.ToInt32(HttpContext.Current.Session["ApprovalID"]);
            }
            set
            {
                if (value == 0)
                    HttpContext.Current.Session["ApprovalID"] = null;
                else
                    HttpContext.Current.Session["ApprovalID"] = value;
            }
        }
        
        public static string AgreementType
        {
            get
            {
                if (HttpContext.Current.Session["AgreementType"] == null)
                    return null;
                else
                    return (string)(HttpContext.Current.Session["AgreementType"]);
            }
            set
            {
                if (value == null)
                    HttpContext.Current.Session["AgreementType"] = null;
                else
                  //  HttpContext.Current.Session["ApprovalID"] = value;
                HttpContext.Current.Session["AgreementType"] = value;
            }
        }


        public static UsersEntity UsersEntity
        {
            get
            {
                if (HttpContext.Current.Session["UsersEntity"] == null)
                    // return new UsersEntity();
                    return null;
                else
                    return (UsersEntity)HttpContext.Current.Session["UsersEntity"];
            }
            set
            {
                HttpContext.Current.Session["UsersEntity"] = value;
            }
        }


    }
}
