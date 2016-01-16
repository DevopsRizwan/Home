<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="ApproverControl.ascx.cs"
    Inherits="Agreement.UserControls.ApproverControl" %>
<%@ Register src="../Navigator.ascx" tagname="Navigator" tagprefix="uc1" %>

<asp:UpdatePanel ID="UpdatePanel1" runat="server">
<ContentTemplate>
<table width="100%" id="tblContainer" runat="server">
    <tr>
        <td colspan="3">
            <uc1:Navigator ID="Navigator1" runat="server" />
        </td>
    </tr>
    <tr>
        <td width="25%">
            Agreement Reviewer<span class="required">*</span>
        </td>
        <td width="45%">
            <asp:DropDownList ID="ddlAgreementReviewer" runat="server">
            </asp:DropDownList>
        </td>
        <td width="30%">
            <asp:RequiredFieldValidator ID="valReqAgreementReviewer" runat="server" ControlToValidate="ddlAgreementReviewer"
                Display="Dynamic" ErrorMessage="please select Agreement Reviewer" ForeColor="Red"
                SetFocusOnError="True" ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
        <td>
            Business Type Approver<span class="required">&nbsp;*</span>
        </td>
        <td>
            <asp:DropDownList ID="ddlBusinessTypeApprover" runat="server">
            </asp:DropDownList>
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqBusinessTypeApprover" runat="server" ControlToValidate="ddlBusinessTypeApprover"
                Display="Dynamic" ErrorMessage="Please select Business Type Approver" ForeColor="Red"
                SetFocusOnError="True" ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
        <td>
            Lawyer Approver<span class="required">&nbsp;*</span>
        </td>
        <td>
            <asp:DropDownList ID="ddlLawyerApprover" runat="server">
            </asp:DropDownList>
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqAgreementReviewer1" runat="server" ControlToValidate="ddlLawyerApprover"
                Display="Dynamic" ErrorMessage="please select Lawyer Approver" ForeColor="Red"
                SetFocusOnError="True" ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
        <td>
            Other Approver
        </td>
        <td>
            <asp:DropDownList ID="ddlOtherApprover" runat="server">
            </asp:DropDownList>
        </td>
        <td>
            &nbsp;
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
        <td>
            <asp:Button ID="btnPrevious" runat="server" Text="Previous" OnClick="btnPrevious_Click" />&nbsp;
            <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" />&nbsp;
            <asp:Button ID="btnNext" runat="server" Text="Next" OnClick="btnNext_Click" ValidationGroup="Next" />&nbsp;
            <asp:Button ID="btnCancel" runat="server" Text="Cancel" OnClick="btnCancel_Click" />
        </td>
        <td>
            <asp:HiddenField ID="hdnAgreementApproversID" runat="server" />
        </td>
    </tr>
</table>
</ContentTemplate>
</asp:UpdatePanel>

