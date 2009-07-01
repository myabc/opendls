package org.opendls.model.dc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DCCoverage component
 *
 * @author alexbcoles
 * @version 1.0
 */
@Embeddable
public class DCCoverage implements Serializable
{
    private static final long serialVersionUID = -6938171677772566512L;
    private Double spatialMinLat;
    private Double spatialMinLong;
    private Double spatialMaxLat;
    private Double spatialMaxLong;
    private String temporal;

    /**
     * @return Returns the spatialMinLat.
     */
    @Column(name = "coverage_spatial_minLat", precision = 8)
    public Double getSpatialMinLat()
    {
        return spatialMinLat;
    }

    /**
     * @return Returns the spatialMinLong.
     */
    @Column(name = "coverage_spatial_minLong", precision = 8)
    public Double getSpatialMinLong()
    {
        return spatialMinLong;
    }

    /**
     * @return Returns the spatialMaxLat.
     */
    @Column(name = "coverage_spatial_maxLat", precision = 8)
    public Double getSpatialMaxLat()
    {
        return spatialMaxLat;
    }

    /**
     * @return Returns the spatialMaxLong.
     */
    @Column(name = "coverage_spatial_maxLong", precision = 8)
    public Double getSpatialMaxLong()
    {
        return spatialMaxLong;
    }

    /**
     * @return Returns the temporal.
     */
    @Column(name = "coverage_temporal", length = 200)
    public String getTemporal()
    {
        return temporal;
    }

    /**
     * @param spatialMinLat
     *            The spatialMinLat to set.
     */
    public void setSpatialMinLat(Double spatialMinLat)
    {
        this.spatialMinLat = spatialMinLat;
    }

    /**
     * @param spatialMinLong
     *            The spatialMinLong to set.
     */
    public void setSpatialMinLong(Double spatialMinLong)
    {
        this.spatialMinLong = spatialMinLong;
    }

    /**
     * @param spatialMaxLat
     *            The spatialMaxLat to set.
     */
    public void setSpatialMaxLat(Double spatialMaxLat)
    {
        this.spatialMaxLat = spatialMaxLat;
    }

    /**
     * @param spatialMaxLong
     *            The spatialMaxLong to set.
     */
    public void setSpatialMaxLong(Double spatialMaxLong)
    {
        this.spatialMaxLong = spatialMaxLong;
    }

    /**
     * @param temporal
     *            The temporal to set.
     */
    public void setTemporal(String temporal)
    {
        this.temporal = temporal;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        final DCCoverage coverage = (DCCoverage) o;

        if (spatialMinLat != null ? !spatialMinLat.equals(coverage
                .getSpatialMinLat()) : coverage.getSpatialMinLat() != null)
            return false;
        if (spatialMinLong != null ? !spatialMinLong.equals(coverage
                .getSpatialMinLong()) : coverage.getSpatialMinLong() != null)
            return false;
        if (spatialMaxLat != null ? !spatialMaxLat.equals(coverage
                .getSpatialMaxLat()) : coverage.getSpatialMaxLat() != null)
            return false;
        if (spatialMaxLong != null ? !spatialMaxLong.equals(coverage
                .getSpatialMaxLong()) : coverage.getSpatialMaxLong() != null)
            return false;
        if (temporal != null ? !temporal.equals(coverage.getTemporal())
                : coverage.getTemporal() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        result = (spatialMinLat != null ? spatialMinLat.hashCode() : 0);
        result = 39 * result
                + (spatialMaxLong != null ? spatialMaxLong.hashCode() : 0);
        result = 39 * result
                + (spatialMaxLat != null ? spatialMaxLat.hashCode() : 0);
        result = 39 * result
                + (spatialMaxLong != null ? spatialMaxLong.hashCode() : 0);
        result = 39 * result + (temporal != null ? temporal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Spatial Min Lat:  ").append(getSpatialMinLat()).append("\n");
        sb.append("Spatial Max Long: ").append(getSpatialMinLong())
                .append("\n");
        sb.append("Spatial Max Lat:  ").append(getSpatialMaxLat()).append("\n");
        sb.append("Spatial Max Long: ").append(getSpatialMaxLong())
                .append("\n");
        sb.append("Temporal:         ").append(getTemporal());
        return sb.toString();
    }

}
