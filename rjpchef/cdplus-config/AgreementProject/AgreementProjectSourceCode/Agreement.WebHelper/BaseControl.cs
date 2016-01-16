/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;

namespace Agreement.WebHelper
{
    public class BaseControl : System.Web.UI.UserControl
    {
        public UsersEntity UserInfo { get; set; }

      

        protected override void OnLoad(EventArgs e)
        {
            //UserInfo = new UsersEntity() { UserID = 5, UserName = "xxxxx", FirstName = "F Name 1" };
            //Session["UsersID"] = UserInfo.UserID;
            base.OnLoad(e);
        }

    }
}
