<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="ViewAgreement.aspx.cs" Inherits="Agreement.ViewAgreement" %>

<%@ Register Src="UserControls/AgreementTypeControl.ascx" TagName="AgreementTypeControl"
    TagPrefix="uc1" %>
<%@ Register Src="UserControls/WorkControl.ascx" TagName="WorkControl" TagPrefix="uc2" %>
<%@ Register src="UserControls/EligibilityControl.ascx" tagname="EligibilityControl" tagprefix="uc3" %>
<%@ Register src="UserControls/ApproverControl.ascx" tagname="ApproverControl" tagprefix="uc4" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .style1
        {
            width: 100%;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong> Agreement Report</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table class="style1">
        <tr>
            <td>
                <strong>Agreement Type:</strong>
            </td>
        </tr>
        <tr>
            <td>
                <uc1:AgreementTypeControl ID="AgreementTypeControl1" runat="server" />
            </td>
        </tr>
        <tr>
            <td>
                <strong>Work</strong>
            </td>
        </tr>
        <tr>
            <td>
                <uc2:WorkControl ID="WorkControl1" runat="server" />
            </td>
        </tr>
        <asp:Panel ID = "ideligibillity" runat="server">
         <tr>
            <td>
                 
                 <strong >Eligibility</strong>
            </td>
        </tr>
        <tr>
            <td>
               
                <uc3:EligibilityControl ID="EligibilityControl1" runat="server" />
               
            </td>
        </tr>
        </asp:Panel>
       
        <tr>
            <td>
               <strong>Approver</strong>
            </td>
        </tr>
        <tr>
            <td>
               
                <uc4:ApproverControl ID="ApproverControl1" runat="server" />
               
            </td>
        </tr>
        <tr>
        <td align ="center">
            <asp:Button ID="btnCancel" runat="server" Text="Cancel" 
                onclick="btnCancel_Click" />
        </td>
        </tr>
    </table>
</asp:Content>
