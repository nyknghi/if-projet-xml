<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet [
<!ENTITY eacute '&#233;'>
<!ENTITY nbsp '&#160;'>
]>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />
	
	<xsl:template match="/">
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="fiche.css" />
				<title>Liste utilisateurs</title>
			</head>
			<body>
				<h1>Service de partage d'informations touristiques</h1>
				<h2>Utilisateurs actifs</h2>
				<table border='1'>
					<tr>
						<th>Nom</th>
						<th>Age</th>
						<th>Genre</th>
						<th>Adresse</th>
						<th>Hobbies</th>
						<th>Activites</th>
						<th>Nb Commentaires</th>
					</tr>
					<xsl:apply-templates select="//user" />
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="user">
		<xsl:apply-templates select="document(.)//utilisateur" />
	</xsl:template>
	
	<xsl:template match="utilisateur">
		<tr>
			<td>
				<xsl:value-of select="nom" />
			</td>
			<td>
				<xsl:value-of select="@age" />
			</td>
			<td>
				<xsl:value-of select="@genre" />
			</td>
			<xsl:apply-templates select="coordonnee" />
			<td>
				<xsl:apply-templates select="hobby" />
			</td>
			<td>
				<xsl:call-template name="nbActivites">
					<xsl:with-param name="idUser" select="@id"/>
				</xsl:call-template>
			</td>
			<td>
				<xsl:call-template name="nbCommentaires">
					<xsl:with-param name="idUser" select="@id"/>
				</xsl:call-template>
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="hobby">
		<xsl:value-of select="." /> &nbsp;
	</xsl:template>

	<xsl:template match="coordonnee">
		<td>
			<xsl:value-of select="adresse/numero" />
			<xsl:choose>
				<xsl:when test="count(adresse/rue) != 0">
						&nbsp;
					Rue
					<xsl:value-of select="adresse/rue" />
				</xsl:when>
				<xsl:otherwise>
						&nbsp;
					Avenue
					<xsl:value-of select="adresse/avenue" />
				</xsl:otherwise>
			</xsl:choose>
				&nbsp;
			<xsl:value-of select="adresse/code" />
				&nbsp;
			<xsl:value-of select="adresse/ville" />
		</td>
	</xsl:template>
	
	<xsl:template name="nbActivites">
		<xsl:param name="idUser"/>
		<xsl:value-of select="count(document(//service/text())//participation[utilisateur/@id=$idUser])" />
	</xsl:template>
	
	<xsl:template name="nbCommentaires">
		<xsl:param name="idUser"/>
		<xsl:value-of select="count(document(//service/text())//utilisateur[@id=$idUser]/../commentaire)" />
	</xsl:template>
</xsl:stylesheet>
