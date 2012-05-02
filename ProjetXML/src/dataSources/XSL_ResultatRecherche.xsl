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
					<xsl:apply-templates select="//form" />
					
					<div id="footer">Copyright © [IF] Projet XML, 2012</div>
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="form">
		<xsl:variable name="id" select="document(.)//utilisateur/@id" />
		<xsl:variable name="ville" select="document(.)//activite/ville" />
		<xsl:variable name="nom" select="document(.)//activite/nom" />
		<xsl:variable name="debut" select="document(.)//activite/@debut" />
		<xsl:variable name="fin" select="document(.)//activite/@fin" />
		<xsl:variable name="type" select="document(.)//activite/@type" />
		<div id="navigation"></div>

		<div id="section-navigation">
			<h3>Informations personnelles</h3>
			<xsl:apply-templates select="document(//user/text())//utilisateur[@id=$id]" />
		</div>
		<div id="content">
			<h3>R&eacute;sultat de la recherche</h3>
			<xsl:choose>
				<xsl:when
					test="$ville != '' and $nom ='' and $debut = '' and $fin = '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut = '' and $fin = '' and $type= ''">
					<xsl:apply-templates select="document(//act/text())//activite[nom=$nom]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom ='' and $debut != '' and $fin = '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[@debut=$debut]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom ='' and $debut = '' and $fin != '' and $type= ''">
					<xsl:apply-templates select="document(//act/text())//activite[@fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut = '' and $fin = '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom ='' and $debut != '' and $fin = '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and @debut=$debut]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom ='' and $debut = '' and $fin != '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and @debut=$debut]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom ='' and $debut = '' and $fin = '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut != '' and $fin = '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and @debut=$debut]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut = '' and $fin != '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and @fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut = '' and $fin = '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom ='' and $debut != '' and $fin != '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[@debut=$debut and @fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom ='' and $debut != '' and $fin = '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[@debut=$debut and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom ='' and $debut = '' and $fin != '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[@fin=$fin and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut != '' and $fin = '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom and @debut=$debut]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut = '' and $fin != '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom and @fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut = '' and $fin = '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut != '' and $fin != '' and $type= ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and @debut=$debut and @fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut != '' and $fin = '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and @debut=$debut and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom ='' and $debut != '' and $fin != '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[@debut=$debut and @fin=$fin and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut != '' and $fin != '' and $type = ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom and @debut=$debut and @fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville = '' and $nom !='' and $debut != '' and $fin != '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and @debut=$debut and @fin=$fin and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom ='' and $debut != '' and $fin != '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and @fin=$fin and @debut=$debut and @fin=$fin]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut = '' and $fin != '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom and @fin=$fin and @type=$type]" />
				</xsl:when>
				<xsl:when
					test="$ville != '' and $nom !='' and $debut != '' and $fin = '' and $type != ''">
					<xsl:apply-templates
						select="document(//act/text())//activite[ville=$ville and nom=$nom and @debut=$debut and @type=$type]" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:apply-templates
						select="document(//act/text())//activite[nom=$nom and ville=$ville 
													and @debut=$debut and @fin=$fin and @type=$type]" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>

	<xsl:template match="utilisateur">
		<table>
			<tr>
				<td>Nom</td>
				<td>
					<xsl:value-of select="nom" />
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td>
					<xsl:value-of select="@age" />
				</td>
			</tr>
			<tr>
				<td>Genre</td>
				<td>
					<xsl:value-of select="@genre" />
				</td>
			</tr>
			<tr>
				<td>Hobbies</td>
				<td>
					<xsl:apply-templates select="hobby" />
				</td>
			</tr>
			<xsl:apply-templates select="coordonnee" />
		</table>
	</xsl:template>

	<xsl:template match="hobby">
		<xsl:value-of select="." /> &nbsp;
	</xsl:template>

	<xsl:template match="coordonnee">
		<tr>
			<td>Adresse</td>
			<td>
				<xsl:value-of select="adresse/numero" />
				<xsl:choose>
					<xsl:when test="count(adresse/rue) != 0">
						&nbsp;Rue
						<xsl:value-of select="adresse/rue" />
					</xsl:when>
					<xsl:otherwise>
						&nbsp;Avenue
						<xsl:value-of select="adresse/avenue" />
					</xsl:otherwise>
				</xsl:choose>
				&nbsp;
				<xsl:value-of select="adresse/code" />
				&nbsp;
				<xsl:value-of select="adresse/ville" />
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="activite">
		<table id="mytable" cellspacing="0">
			<tr>
				<td id="tdF">Intitule</td>
				<td id="tdF">
					<xsl:value-of select="nom" />
				</td>
			</tr>
			<tr>
				<td id="tdF">Ville</td>
				<td id="tdF">
					<xsl:value-of select="ville" />
				</td>
			</tr>
			<tr>
				<td id="tdF">Date
					de d&eacute;but
				</td>
				<td id="tdF">
					<xsl:value-of select="@debut" />
				</td>
			</tr>
			<tr>
				<td id="tdF">Date de fin</td>
				<td id="tdF">
					<xsl:value-of select="@fin" />
				</td>
			</tr>
			<tr>
				<td id="tdF">Type
					d'activit&eacute;
				</td>
				<td id="tdF">
					<xsl:value-of select="@type" />
				</td>
			</tr>
		</table>

		<p>
			Note:
			<xsl:value-of select="note" />
		</p>
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

</xsl:stylesheet>