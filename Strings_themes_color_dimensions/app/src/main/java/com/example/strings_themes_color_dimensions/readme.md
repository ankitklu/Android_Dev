# What is a Recycler View ?
- View Group to show items in list.
- for each item in a data set - it displays a view.
- Efficient way to create a scrollable list.

# View Holders
- To make Recycler view work we have two things mainly
- view holder an a adapter
- the view holder 

## onCreateViewHolder
- Create View Object
- Create a Holder to store this view Object
- ViewHolder - just store view so that it can be recycled

## onBindViewHolder
- Binds data in views
- This method provides a viewholder & position
- Based on the position, it just binds the data into view which is then shown in the app.

# Adapters
- It adapts your data in a format that can be consumed by Recycler View.
- Recycler View requests data from Adapter and adapter provide the data
