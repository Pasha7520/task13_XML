<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    table.tfmt {
                    border: 1px ;
                    }

                    td.colfmt {
                    border: 1px ;
                    background-color: yellow;
                    color: red;
                    text-align:right;
                    }

                    th {
                    background-color: #2E9AFE;
                    color: white;
                    }

                </style>
            </head>

            <body>
                <table class="tfmt">
                    <tr>
                        <th style="width:250px">Name</th>
                        <th style="width:350px">type</th>
                        <th style="width:250px">alcohol</th>
                        <th style="width:250px">manufacturer</th>
                        <th style="width:250px">ingredients</th>
                        <th style="width:250px">alcFraction</th>
                        <th style="width:250px">transparency</th>
                        <th style="width:250px">filtered</th>
                        <th style="width:250px">nutritions</th>
                        <th style="width:250px">vol</th>
                        <th style="width:250px">material</th>

                    </tr>

                    <xsl:for-each select="beers/beer">

                        <tr>
                            <td class="colfmt">
                                <xsl:value-of select="@beerNo"/>
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="name" />
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="type" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="al" />
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="manufacturer" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="ingredient" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="alcFraction" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="transparency" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="filtered" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="nutritions" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="vol" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="tankMaterial" />
                            </td>
                        </tr>

                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>