<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Approvers.aspx.cs" Inherits="Agreement.Approvers" %>

<%@ Register src="Navigator.ascx" tagname="Navigator" tagprefix="uc1" %>

<%@ Register src="UserControls/ApproverControl.ascx" tagname="ApproverControl" tagprefix="uc2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <script src="Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
    <style type="text/css">
        .style1
        {
            width: 100%;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Agreement Approvers</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <%--<tr>
            <td>
                <uc1:Navigator ID="Navigator1" runat="server" />
            </td>
        </tr>--%>
        <tr>
            <td>
             

                <uc2:ApproverControl ID="ApproverControl1" runat="server" />
             

            </td>
        </tr>
    </table>
    <%-- <script type ="text/javascript">

         function validateddlists() {
             if (($('#<%=ddlAgreementReviewer.ClientID %>').attr("selectedIndex") == 0) && ($('#<%=ddlBusinessTypeApprover.ClientID %>').attr("selectedIndex") == 0)) {
                 alert('Please select approver');
                 return false;
             }
           }
    </script>--%>
</asp:Content>
