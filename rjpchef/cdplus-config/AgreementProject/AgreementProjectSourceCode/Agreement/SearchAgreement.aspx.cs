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
using Agreement.BusinessLogic;
using Agreement.BusinessEntity;
using Agreement.WebHelper;

namespace Agreement
{
    public partial class SearchAgreement : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            BindBussinessType();
        }
        private void BindBussinessType()
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

        protected void btnSerch_Click(object sender, EventArgs e)
        {
            AgreementTypeEntity entity = new AgreementTypeEntity();
            entity.AgreementType = rdoAgreementType.SelectedValue;
            entity.Title = txtTitle.Text;
            entity.BusinessTypeID = Convert.ToInt32(ddlBusinessType.SelectedIndex);
            AgreementTypeBI agreementType = new AgreementTypeBI();
            List<AgreementTypeEntity> list = agreementType.ReadSearchItem(entity);
            gvSearch.DataSource = list;
            gvSearch.DataBind();

        }
    }
}