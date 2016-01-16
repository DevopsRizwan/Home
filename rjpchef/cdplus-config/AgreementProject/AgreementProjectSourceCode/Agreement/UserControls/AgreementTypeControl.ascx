<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="AgreementTypeControl.ascx.cs"
    Inherits="Agreement.UserControls.AgreementTypeControl" %>
<%@ Register Src="../Navigator.ascx" TagName="Navigator" TagPrefix="uc1" %>
<style type="text/css">
    .style1
    {
        color: #FF0000;
    }
</style>

<asp:UpdatePanel ID="UpdatePanel1" runat="server">
<ContentTemplate>
<asp:Panel ID="panelVendors" runat="server">
    <table width="100%" id="tbl1" runat="server">
        <tr>
            <td colspan="3">
                <uc1:Navigator ID="Navigator1" runat="server" />
            </td>
        </tr>
        <tr style="height: 30px" valign="top">
            <td width="25%">
                Select Agreement Type
            </td>
            <td width="45%">
                <asp:RadioButtonList ID="rdoAgreementType" runat="server" RepeatDirection="Horizontal"
                    OnSelectedIndexChanged="rdoAgreementType_SelectedIndexChanged" AutoPostBack="true">
                    <asp:ListItem Value="R" Text="Registered Vendor"></asp:ListItem>
                    <asp:ListItem Value="A" Text="Anonymous Agreement"></asp:ListItem>
                </asp:RadioButtonList>
            </td>
            <td width="30%">
                <asp:RequiredFieldValidator ID="valReqAgreementType" runat="server" ControlToValidate="rdoAgreementType"
                    Display="Dynamic" ErrorMessage="Select Agreement Type" ForeColor="Red" SetFocusOnError="True"
                    ValidationGroup="Next"></asp:RequiredFieldValidator>
            </td>
        </tr>
    </table>
   
    <asp:Panel ID="panelAnonymousVendor" runat="server">
        <table width="100%" id="tbl2" runat="server">
            <tr style="height: 30px" valign="top">
                <td width="25%">
                    Select Business Type
                </td>
                <td width="45%">
                    <asp:DropDownList ID="ddlBusinessType" runat="server">
                        <asp:ListItem Value="0" Text="--Select--" Selected="True"></asp:ListItem>
                    </asp:DropDownList>
                </td>
                <td width="30%">
                    <asp:RequiredFieldValidator ID="valReqBusinessType" runat="server" ControlToValidate="ddlBusinessType"
                        Display="Dynamic" ErrorMessage="Select Business Type" ForeColor="Red" SetFocusOnError="True"
                        ValidationGroup="Next"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top">
                    Title
                </td>
                <td>
                    <asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="valReqTitle" runat="server" ControlToValidate="txtTitle"
                        Display="Dynamic" ErrorMessage="Enter Title Value" ForeColor="Red" SetFocusOnError="True"
                        ValidationGroup="Next"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top">
                    Select Work Type
                </td>
                <td>
                    <asp:RadioButtonList ID="rdoWorkType" runat="server">
                        <asp:ListItem Value="W" Text="Contract Work"></asp:ListItem>
                        <asp:ListItem Value="C" Text="Contractor"></asp:ListItem>
                        <asp:ListItem Value="S" Text="Subcontract Services"></asp:ListItem>
                    </asp:RadioButtonList>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="valReqWorkType" runat="server" ControlToValidate="rdoWorkType"
                        Display="Dynamic" ErrorMessage="Select Work Type" ForeColor="Red" SetFocusOnError="True"
                        ValidationGroup="Next"></asp:RequiredFieldValidator>
                </td>
            </tr>
        </table>
    </asp:Panel>
    <asp:Panel ID="panelRegisteredVendor" runat="server">
        <table width="100%" id="Table2" runat="server">
            <tr style="height: 30px" valign="top">
                <td width="25%">
                    Select Registered Vendor
                </td>
                <td width="45%">
                    <asp:DropDownList ID="ddlRegisteredVendor" runat="server" AutoPostBack="True" OnSelectedIndexChanged="ddlRegisteredVendor_SelectedIndexChanged">
                    </asp:DropDownList>
                </td>
                <td width="30%">
                    <%--<asp:RequiredFieldValidator ID="valreqRegisteredVendor" runat="server" ControlToValidate="RegisteredVendor"
                        Display="Dynamic" ErrorMessage="Select Registered Vendor" ForeColor="Red" SetFocusOnError="True"
                        ValidationGroup="Next"></asp:RequiredFieldValidator>--%>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Street Address
                </td>
                <td>
                    <asp:Label ID="lblStreetAdress" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    City
                </td>
                <td>
                    <asp:Label ID="lblCity" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    State
                </td>
                <td>
                    <asp:Label ID="lblState" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Zip
                </td>
                <td>
                    <asp:Label ID="lblZip" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Country
                </td>
                <td>
                    <asp:Label ID="lblCountry" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Phone Number
                </td>
                <td>
                    <asp:Label ID="lblPhoneNumber" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Fax Number
                </td>
                <td>
                    <asp:Label ID="lblFaxNumber" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Contact Name
                </td>
                <td>
                    <asp:Label ID="lblContactName" runat="server"></asp:Label>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    Contact Email Address
                </td>
                <td>
                    <asp:Label ID="lblContactEmail" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="vertical-align: top">
                    Title
                </td>
                <td>
                    <asp:TextBox ID="txtTitleRegistered" runat="server"></asp:TextBox>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="valReqTitleRegistered" runat="server" ControlToValidate="txtTitleRegistered"
                        Display="Dynamic" ErrorMessage="Enter Title Value" ForeColor="Red" SetFocusOnError="True"
                        ValidationGroup="Next"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td>
                    U.S. Tax Identification # <span class="style1">*</span>
                </td>
                <td>
                    <asp:TextBox ID="txtTaxIdentification" runat="server"></asp:TextBox>
                </td>
                <td>
                    <asp:RequiredFieldValidator ID="valReqTaxIdentification" ErrorMessage="Please Enter Identification Number"
                        runat="server" SetFocusOnError="true" Display="Dynamic" ForeColor="Red" ValidationGroup="Next"
                        ControlToValidate="txtTaxIdentification"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr style="height: 30px" valign="top">
                <td>
                    UNIQUE #
                </td>
                <td>
                    <asp:TextBox ID="txtUNIQUE" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td colspan="2" dir="ltr">
                    Does the company intend on releasing &quot;CLIENT COMPANY&quot; technical information?
                </td>
                <td>
                    <asp:RadioButtonList ID="rdotechnical" runat="server" RepeatDirection="Horizontal">
                        <asp:ListItem Text="Yes" Value="Y"></asp:ListItem>
                        <asp:ListItem Text="No" Value="N"></asp:ListItem>
                    </asp:RadioButtonList>
                    &nbsp;
                </td>
            </tr>
        </table>
    </asp:Panel>
    <asp:Panel ID="panelButtons" runat="server">
        <table width="100%" id="Table1" runat="server">
            <tr>
                <td width="25%">
                </td>
                <td width="75%">
                    <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" ValidationGroup="Next" />&nbsp;<asp:Button
                        ID="btnNext" runat="server" Text="Next" OnClick="btnNext_Click" ValidationGroup="Next" />&nbsp;<asp:Button
                            ID="btnCancel" runat="server" Text="Cancel" OnClick="btnCancel_Click" />
                    <asp:HiddenField ID="hdnAgreementID" runat="server" Value="" />
                </td>
            </tr>
        </table>
    </asp:Panel>
</asp:Panel>

</ContentTemplate>
</asp:UpdatePanel>

