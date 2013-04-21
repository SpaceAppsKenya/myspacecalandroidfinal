/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import space.apps.challenge.entities.Satellite;
import space.apps.challenge.util.Assets;

public class SatellitesArrayAdapter extends ArrayAdapter<Satellite> {

    private final List<Satellite> list;
    private final Activity context;

    public SatellitesArrayAdapter(Activity context, List<Satellite> list) {
        super(context, R.layout.satellites_list_layout, list);
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {

        protected TextView satellite, organization, type, launched, height;
        protected ImageView image;
    }
    String plaintext = "";
    String imageURL = "";
    ViewHolder holder = null;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.satellites_list_layout, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.satellite = (TextView) view.findViewById(R.id.satellite);
            viewHolder.satellite.setTextColor(Color.BLACK);
            viewHolder.organization = (TextView) view.findViewById(R.id.organization);
            viewHolder.organization.setTextColor(Color.GRAY);
            viewHolder.type = (TextView) view.findViewById(R.id.type);
            viewHolder.type.setTextColor(Color.GRAY);
            viewHolder.launched = (TextView) view.findViewById(R.id.launched);
            viewHolder.launched.setTextColor(Color.GRAY);
            viewHolder.height = (TextView) view.findViewById(R.id.height);
            viewHolder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(viewHolder);
        } else {
            view = convertView;
//            ((ViewHolder) view.getTag()).time.setTag(list.get(position));
        }
//        holder = (ViewHolder) view.getTag();
//        holder.text.setText("text");
//        holder.text.setText("Text");
//        WASubpod[] sub = list.get(position).getSubpods();
//
//        for (WASubpod subpod : sub) {
//            for (Object element : subpod.getContents()) {
//                if (element instanceof WAPlainText) {
//                    plaintext = ((WAPlainText) element).getText();
//                }
//                if (element instanceof WAImage) {
//                    imageURL = ((WAImage) element).getURL();
//                }
//            }
//        }

//        SimpleDateFormat sdf = new SimpleDateFormat();        
//        holder.time.setText(sdf.format(list.get(position).getTime()));
//        if (!imageURL.equals("")) {
////            Assets.imageDownloader.download(imageURL, holder.time);
//            Assets.drawableManager.fetchDrawableOnThread(imageURL, holder.time);
//        } else {
//            holder.narrative.setText(plaintext);
//        }
        Satellite s = list.get(position);
        
        holder.satellite.setText(s.getName());
        holder.image.setImageBitmap(null);
        holder.organization.setText(s.getCompanies());
        holder.type.setText(s.getType());
        holder.launched.setText(s.getLaunch_date());
        holder.height.setText(s.getOrbit_height());
        return view;
    }
}