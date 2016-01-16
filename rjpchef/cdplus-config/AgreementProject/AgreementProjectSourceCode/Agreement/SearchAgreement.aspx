<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="SearchAgreement.aspx.cs" Inherits="Agreement.SearchAgreement" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Search Agreement</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td width="30%">
                Agreement Type
            </td>
            <td width="40%">
                <asp:RadioButtonList ID="rdoAgreementType" runat="server">
                    <asp:ListItem Value="R" Text="Registered Vendor"></asp:ListItem>
                    <asp:ListItem Value="A" Text="Anonymous Agreement"></asp:ListItem>
                    <asp:ListItem Value="B" Text="Both"></asp:ListItem>
                </asp:RadioButtonList>
            </td>
            <td width="30%">
            </td>
        </tr>
        <tr>
            <td>
                Title
            </td>
            <td>
                <asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                Business Type
            </td>
            <td>
                <asp:DropDownList ID="ddlBusinessType" runat="server">
                </asp:DropDownList>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <asp:Button ID="btnSerch" Text="Search" runat="server" OnClick="btnSerch_Click" />
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <asp:GridView ID="gvSearch" runat="server" AutoGenerateColumns="False" Width="100%"
                    EmptyDataText="No Records Found.">
                    <Columns>
                        <asp:BoundField DataField="AgreementType" HeaderText="Agreement Type" HeaderStyle-CssClass="headertext"
                            ItemStyle-Width="15%" />
                        <asp:BoundField DataField="AgreementTypeID" HeaderText="AgreementTypeID" Visible="false"
                            HeaderStyle-CssClass="headertext" InsertVisible="False" ReadOnly="True"  />
                        <asp:BoundField DataField="Title" HeaderText="Title"  HeaderStyle-CssClass="headertext"
                            ItemStyle-Width="15%" />
                        <asp:BoundField DataField="WorkType" HeaderText="Work Type" 
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                        <asp:BoundField DataField="BusinessType" HeaderText="Business Type" 
                            HeaderStyle-CssClass="headertext" ItemStyle-Width="15%" />
                        <asp:BoundField DataField="Status" HeaderText="Status"  HeaderStyle-CssClass="headertext"
                            ItemStyle-Width="15%" />
                    </Columns>
                </asp:GridView>
            </td>
        </tr>
    </table>
</asp:Content>
