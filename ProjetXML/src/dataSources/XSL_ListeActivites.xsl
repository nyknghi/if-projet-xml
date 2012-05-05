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
				<title>Activites touristiques</title>
			</head>
			<body>
				<div id="container">
					<h2>Service de partage d'informations touristiques</h2>
					<div id="navigation"></div>
					<xsl:apply-templates select="//act" />
					<div id="footer">Copyright © [IF] Projet XML, 2012</div>
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="act">
		<div id="content">
			<h3>Liste
				d'activit&eacute;s
				r&eacute;centes
			</h3>
			<xsl:apply-templates select="document(.)//activite" />
		</div>
	</xsl:template>

	<xsl:template match="activite">
		<table border='1'>
			<tr>
				<td>Intitule</td>
				<td>
					<xsl:value-of select="nom" />
				</td>
			</tr>
			<tr>
				<td>Ville</td>
				<td>
					<xsl:value-of select="ville" />
				</td>
			</tr>
			<tr>
				<td>Date
					de d&eacute;but
				</td>
				<td>
					<xsl:value-of select="@debut" />
				</td>
			</tr>
			<tr>
				<td>Date de fin</td>
				<td>
					<xsl:value-of select="@fin" />
				</td>
			</tr>
			<tr>
				<td>Type
					d'activite
				</td>
				<td>
					<xsl:value-of select="@type" />
				</td>
			</tr>
			<tr>
				<td>Participants
				</td>
				<td>
					<xsl:call-template name="nbParticipants">
						<xsl:with-param name="idAct" select="@id" />
					</xsl:call-template>
				</td>
			</tr>
			<tr>
				<td>Note
				</td>
				<td>
					<xsl:value-of select="note" />
				</td>
			</tr>
		</table>

		<p>
			Commentaires (
			<xsl:call-template name="nbCommentaires" />
			):
		</p>
		<xsl:apply-templates select="commentaire" />
	</xsl:template>

	<xsl:template match="commentaire">
		<p>
			<xsl:value-of select="." />
		</p>
	</xsl:template>

	<xsl:template name="nbCommentaires">
		<xsl:variable name="comment" select="count(commentaire)" />
		<xsl:value-of select="$comment" />
	</xsl:template>

	<xsl:template name="nbParticipants">
		<xsl:param name="idAct" />
		<xsl:value-of
			select="count(document(//service/text())//participation[activite/@id=$idAct])" />
	</xsl:template>

</xsl:stylesheet>